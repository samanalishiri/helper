package com.saman.helper.logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.saman.helper.io.FileUtils.*;

public class DefaultLogger implements Logger {

    private final org.slf4j.Logger logger;

    public DefaultLogger() {
        logger = getLogger();
    }

    public DefaultLogger(String name) {
        logger = getLogger(name);
    }

    @Override
    public void log(String info) {
        logger.info(info);
    }

    @Override
    public void log(byte[] info) {
        logger.info(new String(info), StandardCharsets.UTF_8);
    }

    @Override
    public void log(Exception e) {
        logger.error(e.getMessage());
    }

    @Override
    public void log(final String file, final String info) {

        try {
            write((isExist(file) ? open(file) : create(file)), info);

        } catch (IOException e) {
            System.err.println("error = " + e.getMessage());
        }
    }

    @Override
    public void log(final String file, final byte[] info) {

        try {
            write(isExist(file) ? open(file) : create(file), new String(info));

        } catch (IOException e) {
            System.err.println("error = " + e.getMessage());
        }
    }

    public static Logger newInstance(Class<?> c) {
        return new DefaultLogger(c.getSimpleName());
    }
}
