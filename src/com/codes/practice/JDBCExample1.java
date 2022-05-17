package com.codes.practice;

import java.sql.*;

public class JDBCExample1 {
    static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
    static final String USER = "guest";
    static final String PASS = "guest123";
    static final String QUERY = "SELECT id, first, last, age FROM Employees";


    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //
            // Statement interface cannot accept parameters and useful when you are using static SQL statements at runtime.
            // If you want to run SQL query only once then this interface is preferred over PreparedStatement.
            //
            // when you want to use SQL statements many times.
            // The PreparedStatement interface accepts input parameters at runtime (to execute dynamic SQL queries.).
            // such as
            //  PreparedStatement ps = con.prepareStatement("update STUDENT set NAME = ? where ID = ?");
            //  ps.setString(1, "RAM");
            //  ps.setInt(2, 512);
            //  ps.executeUpdate();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
