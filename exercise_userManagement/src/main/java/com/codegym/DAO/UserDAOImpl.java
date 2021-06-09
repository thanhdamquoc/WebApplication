package com.codegym.DAO;

import com.codegym.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private Connection connection = SQLConnection.getConnection();
    private PreparedStatement preparedStatement = null;

    private static final String SELECT_ALL = "select * from user;";
    private static final String SELECT_BY_ID = "{call SelectUserById(?)}";
    private static final String INSERT = "insert into user (name, email, country) value (?, ?, ?);";
    private static final String UPDATE = "";
    private static final String DELETE = "delete from user where id = ?;";

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> selectById(int id) {
        List<User> users = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_BY_ID);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(userId, name, email, country));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void insert(User user) {
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
