package com.springBoot.example.spring.boot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency {
    @Override
    public void sayHello() {
        System.out.println("hello friends, component twho");
    }
}
