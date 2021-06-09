package com.codegym.dao.productDAO;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.Product;

import java.util.List;

public interface IProductDAO extends IGeneralDAO<Product> {
    List<Product> search(String q);
}
