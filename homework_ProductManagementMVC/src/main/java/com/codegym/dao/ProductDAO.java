package com.codegym.dao;

import com.codegym.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    List<Product> callAll();
    Product findById(int id);
    boolean insert(Product product);
    boolean callInsert(Product product);
    boolean update(int id, Product product);
    boolean remove(int id);
}
