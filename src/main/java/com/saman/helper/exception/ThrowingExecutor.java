package com.saman.helper.exception;

/**
 * @author Saman Alishiri samanalishiri@gmail.com
 * Date 2018-06-24
 */
@FunctionalInterface
public interface ThrowingExecutor<T extends Exception> {
    void execute() throws T;
}
