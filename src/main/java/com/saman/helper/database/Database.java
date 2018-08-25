package com.saman.helper.database;

public interface Database {

    interface Oracle {
        String DRIVER = "oracle.jdbc.driver.OracleDriver";
        String PROTOCOL = "jdbc:oracle:thin";
    }

}
