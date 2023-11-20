package org.example;

import java.sql.*;

public class DBConnection {
    private static String url = "jdbc:mysql://localhost:3306/game";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "notSecure";
    private static Connection con;
    private static String urlstring;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
//                System.out.println("Failed to create database connection");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver for " + driverName);
            e.printStackTrace();
        }
        return con;
    }

    public static void runDBTest() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        con = DBConnection.getConnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT 1");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
        System.out.println(rs);
    }
}
