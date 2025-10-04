/*
 * Copyright 2025 ExperimentalIdea
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
package com.experimentalidea.replaypacketcleaner.job;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;

public class AsyncBufferedInputStream extends InputStream {

    /// Create an AsyncBufferedInputStream. Ideal numberOfBuffers is assumed 3.
    public AsyncBufferedInputStream(InputStream inputStream, int numberOfBuffers, int sizeOfBuffer) {
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null.");
        }
        if (numberOfBuffers < 1) {
            throw new IllegalArgumentException("numberOfBuffers cannot be less than 1. Recommend a value of 3.");
        }
        if (sizeOfBuffer < 1) {
            throw new IllegalArgumentException("sizeOfBuffer cannot be less than 1.");
        }

        this.wrappedinputStream = inputStream;

        this.availableBufferQueue = new ArrayBlockingQueue<Buffer>(numberOfBuffers);
        this.readBufferQueue = new ArrayBlockingQueue<Buffer>(numberOfBuffers);

        this.activeBuffer = new Buffer(sizeOfBuffer);

        for (int i = 1; i < (numberOfBuffers - 1); i++) {
            readBufferQueue.add(new Buffer(sizeOfBuffer));
        }

        this.readThread = Thread.startVirtualThread(new Reader(this));
    }


    private final InputStream wrappedinputStream;
    private volatile boolean closed = false;

    private volatile Thread readThread;

    private final ArrayBlockingQueue<Buffer> availableBufferQueue;
    private final ArrayBlockingQueue<Buffer> readBufferQueue;

    private Buffer activeBuffer;

    private volatile IOException ioException = null;


    @Override
    public int read() throws IOException {
        if (this.ioException != null) {
            throw new IOException("An IOException occurred at some point in the past when data read in.", this.ioException);
        }
        if (this.closed) {
            throw new IOException("Input Stream is closed.");
        }

        if (!this.activeBuffer.hasNextByte()) {
            if (!this.activeBuffer.isEndOfStreamReached()) {
                this.switchBuffers();
                return this.read();
            }
            return -1;
        }

        return this.activeBuffer.getNextByte() & 0xFF;
    }

    @Override
    public int available() {
        if (this.activeBuffer.hasNextByte() || !this.activeBuffer.isEndOfStreamReached()) {
            return 1;
        }
        return 0;
    }


    @Override
    public void close() throws IOException {
        if (!this.closed) {
            if (this.ioException != null) {
                throw new IOException("An IOException occurred at some point in the past when data was read in.", this.ioException);
            }

            this.closed = true;

            this.readThread.interrupt();

            while (true) {
                try {
                    this.readThread.join();
                    break;
                } catch (InterruptedException e) {
                    // ignore
                }
            }
            try {
                this.wrappedinputStream.close();
            } catch (IOException ioException) {
                if (this.ioException != null) {
                    this.ioException.addSuppressed(ioException);
                } else {
                    this.ioException = ioException;
                }
            }

            if (this.ioException != null) {
                throw new IOException("An IOException occurred at some point after the calling of close().", this.ioException);
            }
        }
    }

    /// Takes the currently active buffer and pushes it to the readBufferQueue so it can be reused. (if it's contents have been fully consumed)
    /// Then takes a buffer from the availableBufferQueue to be used going forward.
    private void switchBuffers() {
        if (!this.activeBuffer.hasNextByte()) {
            if (this.activeBuffer.isEndOfStreamReached()) {
                return;
            }
            this.readBufferQueue.add(this.activeBuffer);
            this.activeBuffer = null;

            while (this.activeBuffer == null) {
                try {
                    this.activeBuffer = this.availableBufferQueue.take();
                } catch (InterruptedException e) {
                    // do nothing.
                }
            }
        }
    }


    private class Buffer {

        private Buffer(int maxSize) {
            this.byteBuffer = new byte[maxSize];
            this.nextIndex = 0;
            this.endOfStreamReached = false;
        }

        private final byte[] byteBuffer;
        private int size;
        private int nextIndex;
        private boolean endOfStreamReached;

        private boolean hasNextByte() {
            return this.nextIndex < this.size;
        }

        private byte getNextByte() {
            return this.byteBuffer[this.nextIndex++];
        }

        private byte[] getByteBuffer() {
            return this.byteBuffer;
        }

        private int size() {
            return this.size;
        }

        private void reset(int newSize) {
            this.size = newSize;
            this.nextIndex = 0;
        }

        public boolean isEndOfStreamReached() {
            return this.endOfStreamReached;
        }

        public void setEndOfStreamReached(boolean endOfStreamReached) {
            this.endOfStreamReached = endOfStreamReached;
        }
    }

    private class Reader implements Runnable {

        private Reader(AsyncBufferedInputStream inputStream) {
            this.inputStream = inputStream;
        }

        AsyncBufferedInputStream inputStream;

        @Override
        public void run() {
            int firstByteForNextBuffer = Integer.MAX_VALUE;

            while (true) {
                if (this.inputStream.ioException != null) {
                    return;
                }
                if (this.inputStream.closed || firstByteForNextBuffer == -1) {
                    return;
                }

                // Get the next buffer to be filled.
                Buffer buffer;
                try {
                    buffer = this.inputStream.readBufferQueue.take();
                } catch (InterruptedException e) {
                    continue;
                }

                // Fill the buffer.
                try {
                    byte[] byteBuffer = buffer.getByteBuffer();
                    int newSize = 0;
                    if (firstByteForNextBuffer != Integer.MAX_VALUE) {
                        byteBuffer[0] = (byte) firstByteForNextBuffer;
                        newSize++;
                    }

                    newSize += this.inputStream.wrappedinputStream.read(byteBuffer, newSize, byteBuffer.length - newSize);

                    // It's technically possible that the end of the input stream could line up with the end on the buffer.
                    // So read the next byte to check if we are at the end of the stream and store the value for next time in case this isn't the end.
                    firstByteForNextBuffer = this.inputStream.wrappedinputStream.read();
                    if (firstByteForNextBuffer == -1) {
                        buffer.setEndOfStreamReached(true);
                    }

                    // Update to the new size, reset the next index, and return the buffer for use.
                    buffer.reset(newSize);
                    this.inputStream.availableBufferQueue.add(buffer);

                } catch (IOException ioException) {
                    if (this.inputStream.ioException != null) {
                        this.inputStream.ioException.addSuppressed(this.inputStream.ioException);
                    } else {
                        this.inputStream.ioException = ioException;
                    }

                }
            }
        }

    }

}
