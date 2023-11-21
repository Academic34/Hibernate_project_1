package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Util util = new Util();
    private String SQL;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            SQL = "CREATE TABLE IF NOT EXISTS Users (" +
                    "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "lastName VARCHAR(255), " +
                    "age TINYINT)";
            statement.execute(SQL);
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблицы");
        }
    }

    public void dropUsersTable() {
        SQL = "DROP TABLE IF EXISTS Users";
        try (Statement statement = util.getConnection().createStatement()) {
            statement.execute(SQL);
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении таблицы");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(
                "INSERT INTO users(name, lastName, age) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении пользователя");
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(
                "DELETE FROM users WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении пользователя по id");
        }
    }

    public List<User> getAllUsers() {

        ResultSet resultSet;
        List<User> listUser = new ArrayList<>();
        SQL = "SELECT * FROM users";

        try (Statement statement = util.getConnection().createStatement()) {
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении всех пользователей из БД");
        }

        return listUser;
    }

    public void cleanUsersTable() {
        SQL = "DELETE FROM users";
        try (Statement statement = util.getConnection().createStatement()) {
            statement.execute(SQL);
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении таблицы");
        }
    }
}
