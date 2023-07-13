package com.faith.demo.service;

import com.faith.demo.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
    
    
}
