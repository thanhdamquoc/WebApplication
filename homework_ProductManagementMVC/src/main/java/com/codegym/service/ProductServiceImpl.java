package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private static List<Product> list = new ArrayList<>();
    static {
        list.add(new Product(1, "chair", 10, "a chair", "VN"));
        list.add(new Product(2, "table", 10, "a table", "VN"));
        list.add(new Product(3, "desk", 10, "a desk", "VN"));
        list.add(new Product(4, "stand", 10, "a stand", "VN"));
        list.add(new Product(5, "bed", 10, "a bed", "VN"));
    }

    @Override
    public List<Product> display() {
        return list;
    }

    @Override
    public int getIndex(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()==id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product get(int id) {
        int index = getIndex(id);
        return list.get(index);
    }

    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public void update(int id, Product product) {
        int index = getIndex(id);
        list.set(index, product);
    }

    @Override
    public void remove(int id) {
        int index = getIndex(id);
        list.remove(index);
    }
}
