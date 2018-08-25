package com.saman.helper;

import com.saman.helper.logger.Logger;
import com.saman.helper.logger.LoggerFactory;

import java.util.Arrays;

public class BaseTest {

    protected final Logger logger = LoggerFactory.create(this.getClass());

    protected void waitForm() throws InterruptedException {
        Thread.currentThread().join();
    }

    protected <T> void print(T[] a) {
        logger.log(Arrays.toString(a));
    }

}
