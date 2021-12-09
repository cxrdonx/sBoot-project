package com.springBoot.example.spring.boot.bean;

public class MyOperationImplement implements MyOperation {
    @Override
    public int sum(int number) {
        return number+1;
    }
}
