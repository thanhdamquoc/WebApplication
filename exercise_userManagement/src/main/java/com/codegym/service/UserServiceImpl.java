package com.codegym.service;

import com.codegym.DAO.UserDAO;
import com.codegym.DAO.UserDAOImpl;
import com.codegym.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public List<User> findAll() {
        return userDAO.selectAll();
    }

    @Override
    public List<User> findById(int id) {
        return userDAO.selectById(id);
    }

    @Override
    public void add(User user) {
        userDAO.insert(user);
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void remove(int id) {
        userDAO.delete(id);
    }
}
