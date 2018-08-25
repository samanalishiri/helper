package com.saman.helper.database;

import com.saman.helper.logger.Logger;
import com.saman.helper.logger.LoggerFactory;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionPool {

    private final Logger logger = LoggerFactory.create(ConnectionPool.class);

    private static final ConnectionPool INSTANCE = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    private OracleDataSource dataSource;

    private ConnectionPool() {
    }

    ConnectionPool addDataSource(OracleDataSource dataSource) {
        if (Objects.isNull(this.dataSource))
            this.dataSource = dataSource;

        return this;
    }

    public Connection get() throws SQLException {
        return dataSource.getConnection();
    }

    public boolean test() {

        try (Connection connection = dataSource.getConnection()) {
            return !connection.isClosed();

        } catch (SQLException e) {
            logger.log(e);
        }

        return Boolean.FALSE;
    }


}
