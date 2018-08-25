package com.saman.helper.utils;

import java.util.Arrays;

public final class CollectionUtils {

    public static final String SEPARATOR = ",";

    public static final <T> T random(T[] array) {
        return array[(int) (Math.random() * array.length)];
    }

    public static final String join(String[] array) {
        return String.join(SEPARATOR, Arrays.asList(array));
    }
}
