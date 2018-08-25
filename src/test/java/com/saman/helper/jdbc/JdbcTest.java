package com.saman.helper.jdbc;

import com.saman.helper.BaseTest;
import com.saman.helper.database.ConnectionPool;
import com.saman.helper.database.MetadataHelper;
import com.saman.helper.database.OracleConnectionPoolBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.Connection;
import java.sql.SQLException;

@RunWith(JUnit4.class)
public class JdbcTest extends BaseTest {

    @Ignore
    @Test
    public void connection() {
        try {
            ConnectionPool pool = OracleConnectionPoolBuilder.newInstance()
                    .host("127.0.0.1")
                    .port(1521)
                    .name("helper")
                    .user("saman")
                    .password("saman")
                    .build();

            logger.log("Connect: " + pool.test());

        } catch (SQLException e) {
            logger.log(e);
        }
    }

    @Ignore
    @Test
    public void getColumns() {
        try {
            ConnectionPool pool = OracleConnectionPoolBuilder.newInstance()
                    .host("127.0.0.1")
                    .port(1521)
                    .name("helper")
                    .user("saman")
                    .password("saman")
                    .build();

            Connection connection = pool.get();

            MetadataHelper metadata = new MetadataHelper(connection);
            String[] columns = metadata.getColumns("ITEM");
            print(columns);

            connection.close();
        } catch (SQLException e) {
            logger.log(e);
        }
    }

}
