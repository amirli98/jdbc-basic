package com.fz;

import com.fz.entities.User;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        List<User> users = JdbcOps.getAllUsers("jdbc_tutorial","root","users","1234");
        System.out.println(users);
    }
}
