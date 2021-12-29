package com.springBoot.example.spring.boot.caseuse;

import com.springBoot.example.spring.boot.entity.User;
import com.springBoot.example.spring.boot.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService){
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
