package com.example.testproject.service;

import com.example.testproject.model.UserResponse;
import com.example.testproject.model.UserEntity;

public interface UserService {
    UserResponse getUserById(long id);
    int getAge(UserEntity user);
}
