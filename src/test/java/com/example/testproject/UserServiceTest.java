package com.example.testproject;

import com.example.testproject.dto.UserResponse;
import com.example.testproject.exception.UserNotFoundException;
import com.example.testproject.model.User;
import com.example.testproject.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
public class UserServiceTest {
    static User user;
    UserService userService;
    @Autowired
    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @BeforeAll
    static void init(){
        user = new User(1l, "Roma", "Lutsiv", LocalDate.of(1997, 11, 14));
    }
    @Test
    public void getAgeTest(){
        int expectedAge =  25;
        int actualAge = userService.getAge(user);
        Assertions.assertEquals(expectedAge, actualAge);
    }
    @Test
    public void getUserByIdTest(){
        UserResponse expectedUserResponse = new UserResponse(user.getFirstname(), user.getLastname(), userService.getAge(user));
        UserResponse actualUserResponse = userService.getUserById(1l);
        Assertions.assertEquals(actualUserResponse, expectedUserResponse);
    }
    @Test
    public void getUserByIdExceptionTest(){
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.getUserById(1000l));
    }
}
