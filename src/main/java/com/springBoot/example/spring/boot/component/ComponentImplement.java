package com.springBoot.example.spring.boot.component;

import org.springframework.stereotype.Component;

//inyeccion de dependencias
//crear independencia con component, e inyectarla en otras partes de el proyecto
@Component
public class ComponentImplement implements ComponentDependency {
    @Override
    public void sayHello() {
        System.out.println("Hello friends");
    }
}
