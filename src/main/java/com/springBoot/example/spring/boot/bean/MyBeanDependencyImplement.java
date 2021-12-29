package com.springBoot.example.spring.boot.bean;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanDependencyImplement implements MyBeanWithDependency{
    Log LOGGER = LogFactory.getLog(MyBeanDependencyImplement.class);
    MyOperation myOperation;

    public MyBeanDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("method printWithDependency");
        int number = 25;
        LOGGER.debug("numero: " + number);
        System.out.println("hello, im the bean implementation with dependency");
        System.out.println(myOperation.sum(number));
    }
}
