package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao usersTable = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        usersTable.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        usersTable.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        usersTable.saveUser(name, lastName, age);
        System.out.println("User c именем " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        usersTable.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return usersTable.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        usersTable.cleanUsersTable();
    }
}
