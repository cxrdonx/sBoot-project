package com.springBoot.example.spring.boot;
import com.springBoot.example.spring.boot.bean.MyBean;
import com.springBoot.example.spring.boot.bean.MyBeanWithDependency;
import com.springBoot.example.spring.boot.bean.MyBeanWithPropertiesImplement;
import com.springBoot.example.spring.boot.component.ComponentDependency;
import com.springBoot.example.spring.boot.component.ComponentPalindromeImplement;
import com.springBoot.example.spring.boot.entity.User;
import com.springBoot.example.spring.boot.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	Log LOGGER = LogFactory.getLog(Application.class);
      private ComponentDependency componentDependency;
      private MyBean myBean;
      private MyBeanWithDependency myBeanWithDependency;
      private ComponentPalindromeImplement componentPalindromeImplement;
      private MyBeanWithPropertiesImplement myBeanWithPropertiesImplement;
      private UserPojo userPojo;

      //@Autowired no necesario para versiones de spring recientes
      public Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, ComponentPalindromeImplement componentPalindromeImplement, UserPojo userPojo){
         	this.componentDependency = componentDependency;
         	this.myBean = myBean;
         	this.myBeanWithDependency = myBeanWithDependency;
            this.componentPalindromeImplement = componentPalindromeImplement;
          //  this.myBeanWithPropertiesImplement = myBeanWithPropertiesImplement;
            this.userPojo = userPojo;
	  }
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
	private void saveUsersIndatabase(){
      	 User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 03, 20));
      	 User user2 = new User("federico", "federico@domain.com", LocalDate.of(2021, 02, 12));
      	 List<User> list = Array.asList(user1, user2);
	}

	public void exampleCode(){
		componentDependency.sayHello();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		componentPalindromeImplement.ShowPalindromeLetter();
		//  myBeanWithPropertiesImplement.function();"
		System.out.println(userPojo.getEmail()+"-" +userPojo.getPassword());
		System.out.println(userPojo.getAge());
		LOGGER.error("Error del aplicativo");
	}
}
