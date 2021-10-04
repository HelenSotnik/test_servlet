package com.hillel.database;

import com.hillel.database.util.LogDatabaseMessageUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5434/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "hillel2020";

    private static final Logger LOG = Logger.getLogger(Database.class.getName());

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            LOG.info(LogDatabaseMessageUtil.getSuccessInfoMessage());
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error(LogDatabaseMessageUtil.getErrorMessage());
        }
        return null;
    }
}
