package com.saman.helper.database;

public class StringQueryGenerator {

    public static String from(String tableName) {
        return "SELECT * FROM " + tableName;
    }
}
