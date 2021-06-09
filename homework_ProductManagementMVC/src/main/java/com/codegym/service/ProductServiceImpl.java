package com.codegym.service;

import com.codegym.dao.ProductDAO;
import com.codegym.dao.ProductDAOImpl;
import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Product> display() {

//        return productDAO.findAll();
        return productDAO.callAll();
    }

    @Override
    public Product get(int id) {
        return productDAO.findById(id);
    }

    @Override
    public void add(Product product) {
//        productDAO.insert(product);
        productDAO.callInsert(product);
    }

    @Override
    public void update(int id, Product product) {
        productDAO.update(id, product);
    }

    @Override
    public void remove(int id) {
        productDAO.remove(id);
    }

}
