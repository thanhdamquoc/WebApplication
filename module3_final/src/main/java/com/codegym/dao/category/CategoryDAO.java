package com.codegym.dao.category;

import com.codegym.dao.SQLConnection;
import com.codegym.model.Category;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    Connection connection = SQLConnection.getConnection();

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        String query = "select * from category;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        String query = "select * from category where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  category;
    }

    @Override
    public boolean add(Category category) {
        return false;
    }

    @Override
    public boolean update(int id, Category category) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
