package com.saman.helper.exception;

import java.util.Map;

/**
 * @author Saman Alishiri samanalishiri@gmail.com
 * Date 2018-06-24
 */
public final class ExceptionUtils {

    public static <E extends Exception> void tryCatch(ThrowingExecutor<E> executor) {
        try {
            executor.execute();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public static <E extends Exception> void tryCatch(ThrowingExecutor<E> executor, Class<?> expected, E alternative) {
        try {
            executor.execute();
        } catch (Exception e) {
            throwException(e, expected, alternative);
        }
    }

    public static <E extends Exception> void tryCatch(ThrowingExecutor executor, Map<Class<?>, E> map) {
        try {
            executor.execute();

        } catch (Exception e) {
            iterateMapException(e, map);
        }
    }

    public static <T> T tryCatch(ThrowingSupplier<T> supplier) {

        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }

        return null;
    }

    public static <T, E extends Exception> T tryCatch(ThrowingSupplier<T> supplier, Class<?> expected, E alternative) {
        try {
            return supplier.get();
        } catch (Exception e) {
            throwException(e, expected, alternative);
        }

        return null;
    }

    public static <T, E extends Exception> T tryCatch(ThrowingSupplier<T> supplier, Map<Class<?>, E> map) {
        try {
            return supplier.get();

        } catch (Exception e) {
            iterateMapException(e, map);
        }

        return null;
    }

    public static <E extends Exception> void iterateMapException(final Exception origin, Map<Class<?>, E> map) {
        map.entrySet().stream().forEach(entry -> throwException(origin, entry.getKey(), entry.getValue()));
    }

    private static <T extends Exception> void throwException(Exception origin, Class<?> expected, T alternative) {
        if (origin.getClass() == expected) {
            try {
                throw alternative;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
