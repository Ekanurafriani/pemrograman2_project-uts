package com.app.pasien.utility;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtility {

    private static Connection connection;

    static {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("RumahSakit");
        ds.setUser("root");
        ds.setPassword("");
        try {
            connection = ds.getConnection();
        } catch (SQLException ex) {
            System.out.println("Error : " +ex.getMessage());
        }
        
    }

    public static Connection getConnection() {
        return connection;
    }

}
