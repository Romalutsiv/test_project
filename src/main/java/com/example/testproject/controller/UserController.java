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
    public ResponseEntity<UserResponse> getOneById(@PathVariable String id){
        UserResponse userResponse = userService.getOneById(Long.parseLong(id));
        return ResponseEntity.ok(userResponse);
    }


}
