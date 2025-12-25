package com.example.survey.platform.dao;

import com.example.survey.platform.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
