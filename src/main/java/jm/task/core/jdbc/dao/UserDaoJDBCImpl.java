package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
//        try (Statement statement = Util.getConnection().createStatement()) {
//            String createUsersTable = "CREATE TABLE IF NOT EXISTS Users (" +
//                    "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
//                    "name VARCHAR(255), " +
//                    "lastName VARCHAR(255), " +
//                    "age TINYINT)";
//            statement.execute(createUsersTable);
//        } catch (SQLException e) {
//            System.out.println("Ошибка при создании таблицы");
//        }
    }

    @Override
    public void dropUsersTable() {
//        String dropUsersTable = "DROP TABLE IF EXISTS Users";
//        try (Statement statement = Util.getConnection().createStatement()) {
//            statement.execute(dropUsersTable);
//        } catch (SQLException e) {
//            System.out.println("Ошибка при удалении таблицы");
//        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(
//                "INSERT INTO users(name, lastName, age) VALUES (?, ?, ?)")) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setInt(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Ошибка при добавлении пользователя");
//        }
    }

    @Override
    public void removeUserById(long id) {
//        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement(
//                "DELETE FROM users WHERE id = ?")) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Ошибка при удалении пользователя по id");
//        }
    }

    @Override
    public List<User> getAllUsers() {

//        ResultSet resultSet;
        List<User> listUser = new ArrayList<>();
//        String getAllUsers = "SELECT * FROM users";
//
//        try (Statement statement = Util.getConnection().createStatement()) {
//            resultSet = statement.executeQuery(getAllUsers);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                listUser.add(user);
//            }
//        } catch (SQLException e) {
//            System.out.println("Ошибка при получении всех пользователей из БД");
//        }
        return listUser;
    }

    @Override
    public void cleanUsersTable() {
//        String cleanUsersTable = "DELETE FROM users";
//        try (Statement statement = Util.getConnection().createStatement()) {
//            statement.execute(cleanUsersTable);
//        } catch (SQLException e) {
//            System.out.println("Ошибка при удалении таблицы");
//        }
    }
}
