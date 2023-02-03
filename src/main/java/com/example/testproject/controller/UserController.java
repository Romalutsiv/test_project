package com.example.testproject.controller;

import com.example.testproject.dto.UserResponse;
import com.example.testproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getOneById(@PathVariable(name = "id") long id){
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }


}
