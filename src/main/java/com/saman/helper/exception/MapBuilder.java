package com.saman.helper.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Saman Alishiri samanalishiri@gmail.com
 * Date 2018-06-24
 */
public class MapBuilder<T, E> {
    private final Map map;

    public MapBuilder() {
        map = new HashMap<T, E>();
    }


    public MapBuilder<T, E> put(T key, E value) {
        map.put(key, value);
        return this;
    }

    public Map<T, E> get() {
        return map;
    }

}
