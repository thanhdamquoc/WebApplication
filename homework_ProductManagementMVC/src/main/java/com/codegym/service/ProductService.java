package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> display();
    Product get(int id);
    void add(Product product);
    void update(int id, Product product);
    void remove(int id);
}
