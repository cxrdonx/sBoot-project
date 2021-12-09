package com.springBoot.example.spring.boot.bean;

public class MyBeanDependencyImplement implements MyBeanWithDependency{
    MyOperation myOperation;

    public MyBeanDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 25;
        System.out.println("hello, im the bean implementation with dependency");
        System.out.println(myOperation.sum(number));
    }
}
