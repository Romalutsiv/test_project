package com.example.testproject.service;

import com.example.testproject.TestProjectApplication;
import com.example.testproject.exception.UserNotFoundException;
import com.example.testproject.model.User;
import com.example.testproject.model.UserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@SpringBootTest(classes = TestProjectApplication.class)
public class UserServiceTest {
    static User user;
    @Autowired
    private UserService userService;



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
    @Test
    public void getAgeFromNullUser(){
        Assertions.assertThrows(NullPointerException.class, () -> userService.getAge(null));
    }
    @Test
    public void getAgeFromNullBirthday(){
        Assertions.assertThrows(NullPointerException.class, () -> userService.getAge(new User()));
    }
}
