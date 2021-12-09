package com.springBoot.example.spring.boot.bean;

public class MyBeanImplementation implements MyBean{
    @Override
    public void print() {
        System.out.println("MyBean implementation print");
    }
}
