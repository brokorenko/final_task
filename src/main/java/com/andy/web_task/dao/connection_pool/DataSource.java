package com.andy.web_task.dao.connection_pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataSource {

    private static final Logger logger = LogManager.getRootLogger();
    private static final ConnectionPool connectionPool;

    static {
        connectionPool = new ConnectionPool();
        try {
            connectionPool.initPoolData();
        } catch (ConnectionPoolException e) {
            logger.error("Can't initialize connection pool");
        }
    }

    public static Connection getConnection() {
        return connectionPool.takeConnection();
    }

    public static void returnConnection(Connection connection, Statement statement, ResultSet resultSet) {
        connectionPool.closeConnection(connection, statement, resultSet);
    }
}
