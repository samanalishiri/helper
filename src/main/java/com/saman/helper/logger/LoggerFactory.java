package com.saman.helper.logger;

public class LoggerFactory {

    public static Logger create(Class<?> c) {
        return DefaultLogger.newInstance(c);
    }
}
