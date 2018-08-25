package com.saman.helper.database;

import com.saman.helper.io.FileUtils;
import com.saman.helper.logger.Logger;
import com.saman.helper.logger.LoggerFactory;
import oracle.jdbc.pool.OracleDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import static com.saman.helper.database.Database.Oracle.DRIVER;
import static com.saman.helper.database.Database.Oracle.PROTOCOL;

public class OracleConnectionPoolBuilder {

    private final Logger logger = LoggerFactory.create(OracleConnectionPoolBuilder.class);

    private String protocol = PROTOCOL;
    private String host;
    private int port;
    private String name;
    private String user;
    private String password;
    private String url;
    private String cache = "DEFAULT_CACHE";

    private Properties properties;

    private OracleConnectionPoolBuilder() {
        loadDatabaseProperties();
    }

    private void loadDatabaseProperties() {
        try {
            properties = FileUtils.properties("src/main/resources/connection_pool_cache.properties");

        } catch (IOException e) {
            logger.log(e);
        }
    }

    public static OracleConnectionPoolBuilder newInstance() {
        return new OracleConnectionPoolBuilder();
    }

    public OracleConnectionPoolBuilder protocol() {
        protocol = PROTOCOL;
        return this;
    }

    public OracleConnectionPoolBuilder host(String host) {
        this.host = host;
        return this;
    }

    public OracleConnectionPoolBuilder port(int port) {
        this.port = port;
        return this;
    }

    public OracleConnectionPoolBuilder name(String name) {
        this.name = name;
        return this;
    }

    public OracleConnectionPoolBuilder user(String user) {
        this.user = user;
        return this;
    }

    public OracleConnectionPoolBuilder password(String password) {
        this.password = password;
        return this;
    }

    public OracleConnectionPoolBuilder cache(String cache) {
        this.cache = cache;
        return this;
    }

    public OracleConnectionPoolBuilder driver() {
        try {
            Class.forName(DRIVER);

        } catch (ClassNotFoundException e) {
            logger.log(e);
        }

        return this;
    }

    public String url() {
        return url == null ? (url = protocol + ":@" + host + ":" + port + ":" + name) : url;
    }

    public ConnectionPool build() throws SQLException {
        return ConnectionPool.getInstance().addDataSource(createOracleDataSource());
    }

    private OracleDataSource createOracleDataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL(url());
        dataSource.setUser(user);
        dataSource.setPassword(password);

        dataSource.setConnectionCachingEnabled(true);
        dataSource.setConnectionCacheName(cache);

        dataSource.setConnectionCacheProperties(properties);

        return dataSource;
    }

}
