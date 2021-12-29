package com.springBoot.example.spring.boot.caseuse;

import com.springBoot.example.spring.boot.entity.User;
import com.springBoot.example.spring.boot.service.UserService;
import org.springframework.stereotype.Component;


@Component
public class DeleteUser {
    private UserService userService;

        public DeleteUser(UserService userService){
        this.userService = userService;
    }

    public void delete (Long id){
            userService.delete(id);
    }
}
