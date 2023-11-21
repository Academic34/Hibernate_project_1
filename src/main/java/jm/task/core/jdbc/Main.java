package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        UserService us = new UserServiceImpl();

        us.createUsersTable();

        us.saveUser("first", "lastFirst", (byte) 25);
        us.saveUser("second", "lastSecond", (byte) 30);
        us.saveUser("three", "lastThree", (byte) 23);
        us.saveUser("four", "lastFour", (byte) 23);

        System.out.println(Arrays.toString(us.getAllUsers().toArray()));

        us.cleanUsersTable();
        us.dropUsersTable();

        us.closeConnection();
    }
}
