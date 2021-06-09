package com.codegym.service.product;

import com.codegym.dao.productDAO.IProductDAO;
import com.codegym.dao.productDAO.ProductDAO;
import com.codegym.model.Product;

import java.util.List;

public class ProductService implements IProductService{
    IProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return productDAO.add(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDAO.update(id, product);
    }

    @Override
    public boolean remove(int id) {
        return productDAO.remove(id);
    }

    @Override
    public List<Product> search(String q) {
        return productDAO.search(q);
    }
}
