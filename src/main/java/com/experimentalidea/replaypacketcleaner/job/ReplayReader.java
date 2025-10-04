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

import java.io.*;

public class ReplayReader implements Closeable, AutoCloseable {

    /**
     * Create a replay reader
     *
     * @param inputStream The input stream. Any call to this ReplayReader's .close() method will close the provided input stream.
     */
    public ReplayReader(InputStream inputStream) {
        this(inputStream, false, true);
    }

    /**
     * Create a replay reader
     *
     * @param inputStream The input stream. The use of a {@link BufferedInputStream} with at least a buffer size of 16384 bytes is highly recommended.
     * @param closeable   If false, any call to this ReplayReader's .close() method will not close the provided input stream.
     */
    public ReplayReader(InputStream inputStream, boolean async, boolean closeable) {
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream object cannot be null");
        }

        if (async) {
            inputStream = new AsyncBufferedInputStream(inputStream, 3, 65536);
        } else {
            inputStream = new BufferedInputStream(inputStream, 65536);
        }

        if (closeable) {
            this.inputStream = new DataInputStream(inputStream);
        } else {
            this.inputStream = new DataInputStream(inputStream) {
                @Override
                public void close() throws IOException {
                    // do nothing - we don't want the underlying input stream to be closed in this case
                }
            };
        }
    }

    private final DataInputStream inputStream;
    private long bytesRead = 0;


    public int readByte() throws IOException {
        int byteRead = this.inputStream.read();
        // Initially implemented the end of input stream check using inputStream.available() == 0,
        // but when profiling I found out that 30% of the total execution time for a job was being burned on this single check.
        // Testing with a set replay confirmed the improved execution time, dropping from 233 seconds to 178 seconds.
        // In hindsight, the performance cost of .available() makes a lot of sense. Just didn't think anything of it with my initial implementation.
        // Leaving this note here to ensure I don't forget this.
        if (byteRead == -1) {
            throw new EOFException();
        }
        this.bytesRead++;
        return byteRead & 0xff;
    }

    public int[] readByteArray(int size) throws IOException {
        int[] arrayOfBytes = new int[size];
        for (int i = 0; i < size; i++) {
            arrayOfBytes[i] = this.readByte();
        }
        return arrayOfBytes;
    }

    public short readShort() throws IOException {
        this.bytesRead += 2;
        return this.inputStream.readShort();
    }

    public int readInt() throws IOException {
        this.bytesRead += 4;
        return this.inputStream.readInt();
    }

    public long readLong() throws IOException {
        this.bytesRead += 8;
        return this.inputStream.readLong();
    }

    // copy/pasted from the wiki
    public int readVarInt() throws IOException {
        int value = 0;
        int position = 0;
        byte currentByte;

        while (true) {
            currentByte = (byte) this.readByte();
            value |= (currentByte & 0x7F) << position;

            if ((currentByte & 0x80) == 0) break;

            position += 7;

            if (position >= 32) throw new IOException("VarInt is too big");
        }

        return value;
    }

    // copy/pasted from the wiki
    public long readVarLong() throws IOException {
        long value = 0;
        int position = 0;
        byte currentByte;

        while (true) {
            currentByte = (byte) this.readByte();
            value |= (long) (currentByte & 0x7F) << position;

            if ((currentByte & 0x80) == 0) break;

            position += 7;

            if (position >= 64) throw new IOException("VarLong is too big");
        }

        return value;
    }

    public float readFloat() throws IOException {
        this.bytesRead += 4;
        return this.inputStream.readFloat();
    }

    public double readDouble() throws IOException {
        this.bytesRead += 8;
        return this.inputStream.readDouble();
    }

    public boolean readBoolean() throws IOException {
        this.bytesRead += 1;
        return this.inputStream.readBoolean();
    }

    /**
     * Get the total number of bytes read/skipped by this ReplayReader since it was created.
     * If any IOExceptions have occurred since the creation of this ReplayReader, the number of bytes read returned may be inaccurate.
     *
     * @return The total number of bytes that have been read/skipped.
     */
    public long bytesRead() {
        return this.bytesRead;
    }

    public int available() throws IOException {
        return this.inputStream.available();
    }

    public int skip(int i) throws IOException {
        int skipped = this.inputStream.skipBytes(i);
        this.bytesRead += skipped;
        return skipped;
    }

    public void close() throws IOException {
        this.inputStream.close();
    }


}
