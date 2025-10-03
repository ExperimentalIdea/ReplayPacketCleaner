package com.experimentalidea.replaypacketcleaner.job;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;

/// A buffered output stream that writes the buffer on a separate thread.
public class AsyncBufferedOutputStream extends OutputStream {

    /// Create an AsyncBufferedOutputStream. Ideal numberOfBuffers is 3.
    public AsyncBufferedOutputStream(OutputStream outputStream, int numberOfBuffers, int sizeOfBuffer) {
        if (outputStream == null) {
            throw new IllegalArgumentException("outputStream cannot be null.");
        }
        if (numberOfBuffers < 1) {
            throw new IllegalArgumentException("numberOfBuffers cannot be less than 1. Recommend a value of 3.");
        }
        if (sizeOfBuffer < 1) {
            throw new IllegalArgumentException("sizeOfBuffer cannot be less than 1.");
        }

        this.wrappedOutputStream = outputStream;

        this.availableBufferQueue = new ArrayBlockingQueue<Buffer>(numberOfBuffers);
        this.writeBufferQueue = new ArrayBlockingQueue<Buffer>(numberOfBuffers);

        this.activeBuffer = new Buffer(sizeOfBuffer);

        for (int i = 1; i < (numberOfBuffers - 1); i++) {
            availableBufferQueue.add(new Buffer(sizeOfBuffer));
        }
    }

    private final OutputStream wrappedOutputStream;
    private volatile boolean closed = false;
    private volatile boolean flushing = false;

    private volatile Thread writeThread;

    private final ArrayBlockingQueue<Buffer> availableBufferQueue;
    private final ArrayBlockingQueue<Buffer> writeBufferQueue;

    private Buffer activeBuffer;

    private volatile IOException ioException = null;


    @Override
    public void write(int i) throws IOException {
        if (this.ioException != null) {
            throw new IOException("An IOException occurred at some point in the past when data was written out.", this.ioException);
        }
        if (this.closed) {
            throw new IOException("Output Stream is closed.");
        }

        if (this.writeThread == null) {
            this.writeThread = Thread.startVirtualThread(new Writer(this));
        }

        if (this.activeBuffer.isFull()) {
            this.switchBuffers();
        }

        this.activeBuffer.add((byte) i);
    }

 /*   @Override
    public void write(byte[] b) throws IOException {

    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {

    }*/

    /// Flushes all data currently held by this output stream. Blocks until all data has been flushed or an IOException occurs.
    @Override
    public void flush() throws IOException {
        if (this.ioException != null) {
            throw new IOException("An IOException occurred at some point in the past when data was written out.", this.ioException);
        }
        if (this.closed) {
            throw new IOException("Output Stream is closed.");
        }

        this.switchBuffers();

        this.flushing = true;

        this.writeThread.interrupt();

        while (true) {
            try {
                this.writeThread.join();
                break;
            } catch (InterruptedException e) {
                // ignore
            }
        }

        this.writeThread = null;

        this.flushing = false;

        if (this.ioException != null) {
            throw new IOException("An IOException occurred at some point after the calling of flush()", this.ioException);
        }
    }

    @Override
    public void close() throws IOException {
        if (!closed) {
            if (this.ioException != null) {
                throw new IOException("An IOException occurred at some point in the past when data was written out.", this.ioException);
            }

            // Ensure the active buffer's contents can be written out.
            this.switchBuffers();

            this.closed = true;

            this.writeThread.interrupt();

            while (true) {
                try {
                    this.writeThread.join();
                    break;
                } catch (InterruptedException e) {
                    // ignore
                }
            }
            try {
                wrappedOutputStream.close();
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

    /// Takes the currently active buffer and pushes it to the writeBufferQueue so it's contents can be written out. (if it is not empty)
    /// Then takes a buffer from the availableBufferQueue to be used going forward.
    private void switchBuffers() {
        if (!this.activeBuffer.isEmpty()) {
            this.writeBufferQueue.add(this.activeBuffer);
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

        private Buffer(int size) {
            this.byteBuffer = new byte[size];
            this.nextIndex = 0;
        }

        private final byte[] byteBuffer;
        private int nextIndex;

        private void add(byte b) {
            this.byteBuffer[this.nextIndex++] = b;
        }

        private int getRemainingCapacity() {
            return this.byteBuffer.length - this.nextIndex;
        }

        private boolean isFull() {
            return this.getRemainingCapacity() < 1;
        }

        private boolean isEmpty() {
            return this.nextIndex == 0;
        }

        private byte[] getByteBuffer() {
            return this.byteBuffer;
        }

        private int size() {
            return Math.min(this.nextIndex, this.byteBuffer.length);
        }

        private void reset() {
            this.nextIndex = 0;
        }

    }


    private class Writer implements Runnable {

        private Writer(AsyncBufferedOutputStream outputStream) {
            this.outputStream = outputStream;
        }

        AsyncBufferedOutputStream outputStream;

        @Override
        public void run() {
            while (true) {
                if (this.outputStream.ioException != null) {
                    return;
                }
                if ((this.outputStream.flushing || this.outputStream.closed) && this.outputStream.writeBufferQueue.isEmpty()) {
                    return;
                }

                // Get the next buffer to be written out.
                Buffer buffer;
                try {
                    buffer = this.outputStream.writeBufferQueue.take();
                } catch (InterruptedException e) {
                    continue;
                }

                // Write out the buffer.
                if (!buffer.isEmpty()) {
                    try {
                        this.outputStream.wrappedOutputStream.write(buffer.getByteBuffer(), 0, buffer.size());
                    } catch (IOException ioException) {
                        if (this.outputStream.ioException != null) {
                            this.outputStream.ioException.addSuppressed(this.outputStream.ioException);
                        } else {
                            this.outputStream.ioException = ioException;
                        }
                    }
                }

                // Reset & return the buffer to be reused in the future.
                buffer.reset();
                this.outputStream.availableBufferQueue.add(buffer);
            }

        }
    }

}
