package com.faith.demo.repository;

import com.faith.demo.entity.User;

import java.util.List;

public interface IUserDao {

    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
    
}
