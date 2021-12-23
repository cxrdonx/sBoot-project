package com.springBoot.example.spring.boot.caseuse;

import com.springBoot.example.spring.boot.entity.User;
import com.springBoot.example.spring.boot.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser {
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
