package com.example.testproject.controller;

import com.example.testproject.model.UserResponse;
import com.example.testproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    private final long VALID_ID = 1l;
    @Test
    public void getUserByIdStatus200Test() throws Exception {
        UserResponse userResponse = userService.getUserById(VALID_ID);
        mvc.perform(MockMvcRequestBuilders.get("/api/users/" + VALID_ID))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value(userResponse.getFirstname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value(userResponse.getLastname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(userResponse.getAge()));
    }
    @Test
    public void getUserByInvalidLongIdTest() throws Exception {
        long invalidId = -1;

        mvc.perform(MockMvcRequestBuilders.get("/api/users/" + invalidId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User with id = " + invalidId + " not found!!"));

    }
    @Test
    public void getUserByInvalidStringIdTest() throws Exception{
        String invalidId = "q";
        mvc.perform(MockMvcRequestBuilders.get("/api/users/" + invalidId))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Id must be the number!"));

    }


}