package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findById(int id);
    void add(User user);
    void update(int id, User user);
    void remove(int id);
}
