package com.experimentalidea.replaypacketcleaner;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.*;

public class Log {


    private static Logger logger = Logger.getGlobal();

    protected static void setLogger(Logger logger) {
        if (logger != null) {
            Log.logger = logger;
        }
    }

    public static Logger getLogger() {
        return Log.logger;
    }


    public static void info(String msg) {
        Log.logger.info(msg);
    }

    public static void warning(String msg) {
        Log.logger.warning(msg);
    }

    public static void severe(String msg) {
        Log.logger.severe(msg);
    }

    public static void severe(String msg, Throwable throwable) {
        Log.logger.log(Level.SEVERE, msg, throwable);
    }



    public static class LogCollectionHandler extends Handler {

        /// When/if the queue is filled, the oldest log records are disregarded.
        public LogCollectionHandler(LinkedBlockingDeque<LogRecord> logQueue) {
            Objects.requireNonNull(logQueue, "logQueue cannot be null");
            this.logQueue = logQueue;
        }

        private final LinkedBlockingDeque<LogRecord> logQueue;
        private final SimpleFormatter formatter = new SimpleFormatter();


        @Override
        public void publish(LogRecord logRecord) {
            if (!this.logQueue.offer(logRecord)) {
                this.logQueue.pollFirst(); // remove oldest element.
                this.publish(logRecord);
            }
        }

        @Override
        public void flush() {
            // do nothing
        }

        @Override
        public void close() throws SecurityException {
            // do nothing
        }

    }

}
