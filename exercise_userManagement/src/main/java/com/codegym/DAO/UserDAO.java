package com.codegym.DAO;

import com.codegym.model.User;

import java.util.List;

public interface UserDAO {
    List<User> selectAll();
    List<User> selectById(int id);
    void insert(User user);
    void update(int id, User user);
    void delete(int id);
}
