package com.kniet.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {

        //just test to check database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root";
        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl,user,pass);

            System.out.println("Connection successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
