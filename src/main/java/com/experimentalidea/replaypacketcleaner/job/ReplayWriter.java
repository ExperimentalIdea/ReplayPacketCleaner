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

public class ReplayWriter implements Closeable, AutoCloseable, Flushable {

    /**
     * Create a replay writer
     *
     * @param outputStream The output stream. Any call to this ReplayWriter's .close() method will close the provided output stream.
     */
    public ReplayWriter(OutputStream outputStream) {
        this(outputStream, false, true);
    }

    /**
     * Create a replay writer
     *
     * @param outputStream The output stream.
     * @param async        If true, a separate thread will handle writing out the data to the provided output stream.
     * @param closeable    If false, any call to this ReplayWriter's .close() method will not close the provided output stream.
     */
    public ReplayWriter(OutputStream outputStream, boolean async, boolean closeable) {
        if (outputStream == null) {
            throw new IllegalArgumentException("OutputStream object cannot be null");
        }

        if (async) {
            outputStream = new AsyncBufferedOutputStream(outputStream, 3, 65536);
        } else {
            outputStream = new BufferedOutputStream(outputStream, 65536);
        }

        if (closeable) {
            this.outputStream = new DataOutputStream(outputStream);
        } else {
            this.outputStream = new DataOutputStream(outputStream) {
                @Override
                public void close() throws IOException {
                    flush();
                    // do nothing - we don't want the underlying output stream to be closed in this case
                }
            };
        }
    }

    private final DataOutputStream outputStream;
    private long bytesWritten = 0;


    /**
     * Determine the number of bytes a varInt value requires.
     */
    public static int sizeOfVarInt(int value) {
        int size = 0;
        while (true) {
            if ((value & ~0x7F) == 0) {
                return size + 1;
            }
            value >>>= 7;
            size++;
        }
    }

    /**
     * Determine the number of bytes a varLong value requires.
     */
    public static int sizeOfVarLong(long value) {
        int size = 0;
        while (true) {
            if ((value & ~((long) 0x7F)) == 0) {
                return size + 1;
            }
            value >>>= 7;
            size++;
        }
    }


    public void writeByte(int value) throws IOException {
        this.bytesWritten++;
        this.outputStream.write(value & 0xff);
    }

    public void writeByteArray(int[] arrayOfValues) throws IOException {
        for (int value : arrayOfValues) {
            this.writeByte(value);
        }
    }

    public void writeShort(short value) throws IOException {
        this.bytesWritten += 2;
        this.outputStream.writeShort(value);
    }

    public void writeInt(int value) throws IOException {
        this.bytesWritten += 4;
        this.outputStream.writeInt(value);
    }

    public void writeLong(long value) throws IOException {
        this.bytesWritten += 8;
        this.outputStream.writeLong(value);
    }

    // copy/pasted from the wiki
    public void writeVarInt(int value) throws IOException {
        while (true) {
            if ((value & ~0x7F) == 0) {
                this.writeByte(value);
                return;
            }

            this.writeByte((value & 0x7F) | 0x80);

            // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
            value >>>= 7;
        }
    }

    // copy/pasted from the wiki
    public void writeVarLong(long value) throws IOException {
        while (true) {
            if ((value & ~((long) 0x7F)) == 0) {
                this.writeByte((int) value);
                return;
            }

            this.writeByte((int) ((value & 0x7F) | 0x80));

            // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
            value >>>= 7;
        }
    }

    public void writeFloat(float value) throws IOException {
        this.bytesWritten += 4;
        this.outputStream.writeFloat(value);
    }

    public void writeDouble(double value) throws IOException {
        this.bytesWritten += 8;
        this.outputStream.writeDouble(value);
    }

    public void writeBoolean(boolean value) throws IOException {
        this.bytesWritten++;
        this.outputStream.writeBoolean(value);
    }

    /**
     * Get the total number of bytes written by this ReplayWriter since it was created.
     * If any IOExceptions have occurred since the creation of this ReplayWriter, the number of bytes written returned may be inaccurate.
     *
     * @return The total number of bytes written.
     */
    public long bytesWritten() {
        return this.bytesWritten;
    }

    public void flush() throws IOException {
        this.outputStream.flush();
    }

    public void close() throws IOException {
        this.outputStream.close();
    }


}
