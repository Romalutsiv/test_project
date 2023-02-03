package com.example.testproject.service;

import com.example.testproject.model.UserResponse;
import com.example.testproject.model.User;

public interface UserService {
    UserResponse getUserById(long id);
    int getAge(User user);
}
