package org.example;

import org.example.util.ConnectionManager;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class jdbcRunner {
    public static void main(String[] args) {

        findInfoById(12);
    }
    //List <ticket> tickets= new ArrayList<>();

    public static ticket findInfoById(int id) {
        String findAllsql = """ 
                Select *
                from ticket 
                where id =? 
                """;
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(findAllsql)) {
            prepareStatement.setLong(1, id);
            var resultSet = prepareStatement.executeQuery();
            ticket tickets = null;
            while (resultSet.next()) {
                tickets = new ticket(
                        resultSet.getLong("id"),
                        resultSet.getString("data"),
                        resultSet.getLong("cost"));

//            System.out.println(resultSet.getLong("id"));
//            System.out.println(resultSet.getString("data"));
//            System.out.println(resultSet.getBigDecimal("cost"));
//            System.out.println("------------------------------------");
            }
            return tickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


//    finally{
//        ConnectionManager.closePool();
//    }
//}
