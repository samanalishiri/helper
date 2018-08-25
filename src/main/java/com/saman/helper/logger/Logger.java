package com.saman.helper.logger;

public interface Logger {

    default org.slf4j.Logger getLogger() {
        return org.slf4j.LoggerFactory.getLogger(this.getClass().getSimpleName());
    }

    default org.slf4j.Logger getLogger(String name) {
        return org.slf4j.LoggerFactory.getLogger(name);
    }

    void log(String info);

    void log(byte[] info);

    void log(Exception e);

    void log(String file, String info);

    void log(String file, byte[] info);
}
