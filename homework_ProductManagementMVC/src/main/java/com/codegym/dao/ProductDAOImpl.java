package com.codegym.dao;

import com.codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{
    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String CALL_PROCEDURE_VIEW_ALL_PRODUCTS = "{call viewAllProducts()}";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?";
    private static final String INSERT_INTO_PRODUCT = "insert into product (name, price, description, origin) value (?, ?, ?, ?);";
    private static final String CALL_INSERT_PRODUCT = "{call addNewProduct(?, ?, ?, ?)}";
    private static final String UPDATE_PRODUCT = "update product set name = ?, price = ?, description = ?, origin = ? where id = ?;";
    private static final String DELETE_FROM_PRODUCT = "delete from product where id = ?;";

    @Override
    public List<Product> findAll() {
        Connection connection = SQLConnection.getConnection();
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String origin = resultSet.getString("origin");
                products.add(new Product(id, name, price, description, origin));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> callAll() {
        Connection connection = SQLConnection.getConnection();
        List<Product> products = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_PROCEDURE_VIEW_ALL_PRODUCTS);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String origin = resultSet.getString("origin");
                products.add(new Product(id, name, price, description, origin));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String origin = resultSet.getString("origin");
                product = new Product(id, name, price, description, origin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean insert(Product product) {
        int rowsInserted = 0;
        String name = product.getName();
        double price = product.getPrice();
        String description = product.getDescription();
        String origin = product.getOrigin();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, origin);
            rowsInserted = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsInserted != 0;
    }

    @Override
    public boolean callInsert(Product product) {
        int rowsInserted = 0;
        Connection connection = SQLConnection.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(CALL_INSERT_PRODUCT);
            callableStatement.setString(1, product.getName());
            callableStatement.setDouble(2, product.getPrice());
            callableStatement.setString(3, product.getDescription());
            callableStatement.setString(4, product.getOrigin());
            rowsInserted = callableStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsInserted != 0;
    }

    @Override
    public boolean update(int id, Product product) {
        int rowsUpdated = 0;
        String name = product.getName();
        double price = product.getPrice();
        String description = product.getDescription();
        String origin = product.getOrigin();
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, origin);
            preparedStatement.setInt(5,id);
            rowsUpdated = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsUpdated != 0;
    }

    @Override
    public boolean remove(int id) {
        int rowsRemoved = 0;
        Connection connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_PRODUCT);
            preparedStatement.setInt(1, id);
            rowsRemoved = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsRemoved != 0;
    }
}
