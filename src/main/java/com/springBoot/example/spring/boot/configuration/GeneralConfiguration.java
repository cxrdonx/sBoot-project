package com.springBoot.example.spring.boot.configuration;

import com.springBoot.example.spring.boot.bean.MyBeanWithPropertiesImplement;
import com.springBoot.example.spring.boot.bean.MyBeanWithProperties;
import com.springBoot.example.spring.boot.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;
    @Value("${value.apellido}")
    private String apellido;
    @Value("${value.random}")
    private String random;
    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, apellido);
    }
}
