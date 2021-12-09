package com.springBoot.example.spring.boot.configuration;

import com.springBoot.example.spring.boot.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanImplementation2();
    }
    @Bean
    public MyOperation beanOperationNumber(){
        return new MyOperationImplement();
    }
    @Bean
    public MyBeanWithDependency beanOperationNumberWithDependency(MyOperation myOperation){
        return new MyBeanDependencyImplement(myOperation);
    }
}
