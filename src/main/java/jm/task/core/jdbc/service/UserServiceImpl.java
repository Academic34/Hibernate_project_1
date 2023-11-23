package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao usersTable = new UserDaoJDBCImpl();


    public void createUsersTable() {
        usersTable.createUsersTable();
    }

    public void dropUsersTable() {
        usersTable.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        usersTable.saveUser(name, lastName, age);
        System.out.println("User c именем " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        usersTable.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return usersTable.getAllUsers();
    }

    public void cleanUsersTable() {
        usersTable.cleanUsersTable();
    }

}
