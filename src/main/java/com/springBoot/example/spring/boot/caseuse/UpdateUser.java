package com.springBoot.example.spring.boot.caseuse;

import com.springBoot.example.spring.boot.service.UserService;

public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService){
        this.userService = userService;
    }
}
