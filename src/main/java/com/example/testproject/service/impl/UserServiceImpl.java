package com.example.testproject.service.impl;

import com.example.testproject.model.UserResponse;
import com.example.testproject.exception.UserNotFoundException;
import com.example.testproject.model.User;
import com.example.testproject.repository.UserRepository;
import com.example.testproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse getUserById(long id) {
        User userFromDb = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id = " + id + " not found!!"));
        return new UserResponse(
                    userFromDb.getFirstname(),
                    userFromDb.getLastname(),
                    getAge(userFromDb));
    }

    @Override
    public int getAge(User user) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - user.getBirthday().getYear();
        if(today.getMonthValue() - user.getBirthday().getMonthValue() < 0) age -= 1;
        else if( today.getMonthValue() - user.getBirthday().getMonthValue() == 0) {
            if (today.getDayOfMonth() - user.getBirthday().getDayOfMonth() < 0) age -= 1;
        }


        return age;
    }
}
