package com.Interview.BehavioralDesignPatterns;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCExample {

    public static void main(String[] args) {

        List<Employee> result = new ArrayList<>();

        String SQL_SELECT = "Select * from EMPLOYEE";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/test", "postgres", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                BigDecimal salary = resultSet.getBigDecimal("SALARY");
                Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setSalary(salary);
                // Timestamp -> LocalDateTime
                employee.setCreatedDate(createdDate.toLocalDateTime());

                result.add(employee);

            }
            result.forEach(x -> System.out.println(x));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }







}



