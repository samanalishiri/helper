package com.saman.helper.database;

import java.sql.*;

public class MetadataHelper {

    private Connection connection;

    public MetadataHelper(Connection connection) {
        this.connection = connection;
    }

    public String[] getColumns(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet result = statement.executeQuery(StringQueryGenerator.from(tableName))) {
                return createColumnArray(result.getMetaData());
            }
        }
    }

    private String[] createColumnArray(ResultSetMetaData metaData) throws SQLException {
        String[] columns = new String[metaData.getColumnCount()];

        for (int i = 1; i <= columns.length; i++)
            columns[i - 1] = metaData.getColumnName(i);

        return columns;
    }


}
