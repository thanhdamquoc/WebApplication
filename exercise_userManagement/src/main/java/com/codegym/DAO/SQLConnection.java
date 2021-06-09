package com.codegym.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {

    private static final String jdbcURL = "jdbc:mysql://localhost:3306/user_management?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
