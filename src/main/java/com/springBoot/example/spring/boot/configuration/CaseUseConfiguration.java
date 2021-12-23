package com.springBoot.example.spring.boot.configuration;

import com.springBoot.example.spring.boot.caseuse.GetUser;
import com.springBoot.example.spring.boot.caseuse.GetUserImplement;
import com.springBoot.example.spring.boot.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
     @Bean
    GetUser getUser(UserService userService){
         return new GetUserImplement(userService);
     }

}
