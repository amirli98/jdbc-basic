package com.fz;

import com.fz.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:Fazil Amirli
 * Created on: 8/3/2021
 */
public class JdbcOps {
    //JDBC Connection interface
    //JDBC Statement interface
    //JDBC PreparedStatement interface
    //JDBC CallableStatement interface
    //JDBC ResultSet interface
    //JDBC ResultSetMetaData interface
    //JDBC DatabaseMetaData interface
    //JDBC DriverManager class

    private static final String templateURLForMySqlDatabase = "jdbc:mysql://localhost:3306/";
    public static List<User> getAllUsers(String dbName, String username, String tableName, String password){
        List<User> users = new ArrayList<>();
        String url = templateURLForMySqlDatabase+dbName;
        Statement statement;

        try(Connection connection = DriverManager.getConnection(url, username, password)){
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from "+tableName);
            while (resultSet.next()){
                User user = new User();
                user.setCountry(resultSet.getString("country"));
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            }catch (Exception e){
                e.printStackTrace();
            }


        return users;
    }

    /*public static List<User> getAll(String tableName) throws SQLException {
        ResultSet resultSet = configureConnection().executeQuery("select * from "+tableName);
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            User user = new User();

        }
        return users;
    }*/
}
