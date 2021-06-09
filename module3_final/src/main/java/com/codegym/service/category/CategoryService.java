package com.codegym.service.category;

import com.codegym.dao.category.CategoryDAO;
import com.codegym.dao.category.ICategoryDAO;
import com.codegym.model.Category;

import java.util.List;

public class CategoryService implements ICategoryService{
    ICategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
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
