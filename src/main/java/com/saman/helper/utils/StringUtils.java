package com.saman.helper.utils;

import java.util.Objects;

public final class StringUtils {

    public static final String EMPTY = "";
    public static final String NULL = null;

    public static boolean isEmpty(String val) {
        return Objects.isNull(val) || val.isEmpty();
    }

    public static boolean notEmpty(String val) {
        return !isEmpty(val);
    }

    public static char[] getChar(String str) {
        return str.toCharArray();
    }

    public static byte[] getByte(String str) {
        return str.getBytes();
    }
}
