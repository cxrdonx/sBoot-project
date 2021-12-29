package com.springBoot.example.spring.boot;
import com.springBoot.example.spring.boot.bean.MyBean;
import com.springBoot.example.spring.boot.bean.MyBeanWithDependency;
import com.springBoot.example.spring.boot.bean.MyBeanWithPropertiesImplement;
import com.springBoot.example.spring.boot.component.ComponentDependency;
import com.springBoot.example.spring.boot.component.ComponentPalindromeImplement;
import com.springBoot.example.spring.boot.entity.User;
import com.springBoot.example.spring.boot.pojo.UserPojo;
import com.springBoot.example.spring.boot.repository.UserRepository;
import com.springBoot.example.spring.boot.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	Log LOGGER = LogFactory.getLog(Application.class);
      private ComponentDependency componentDependency;
      private MyBean myBean;
      private MyBeanWithDependency myBeanWithDependency;
      private ComponentPalindromeImplement componentPalindromeImplement;
      private MyBeanWithPropertiesImplement myBeanWithPropertiesImplement;
      private UserPojo userPojo;
      private UserRepository userRepository;
      private UserService userService;

      //@Autowired no necesario para versiones de spring recientes
      public Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, ComponentPalindromeImplement componentPalindromeImplement, UserPojo userPojo, UserRepository userRepository, UserService userService){
         	this.componentDependency = componentDependency;
         	this.myBean = myBean;
         	this.myBeanWithDependency = myBeanWithDependency;
            this.componentPalindromeImplement = componentPalindromeImplement;
          //  this.myBeanWithPropertiesImplement = myBeanWithPropertiesImplement;
            this.userPojo = userPojo;
            this.userRepository = userRepository;
            this.userService = userService;
	  }
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
          saveUsersIndatabase();
          getInformationJpqlFromUser();
          saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional(){
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());
		List<User> users = Arrays.asList(test1, test2, test3, test4);
		userService.saveTransactional(users);
		userService.getAllUsers().stream().forEach(user -> LOGGER.info("este es el usuario dentro del metodo transaccional" + user));
	}

	private void getInformationJpqlFromUser(){

      	LOGGER.info("user with method findByYserEmail" +userRepository.findByUserEmail("federico@domain.com").orElseThrow(
				()-> new RuntimeException("no se encontro el usuario con ese correo")));
      	userRepository.findAndSort("John", Sort.by("id").descending()).stream()
		.forEach(user -> LOGGER.info("user with sort method"));
      	userRepository.findByName("John")
				.stream().forEach(user -> LOGGER.info("user with query method: " + user));
      	LOGGER.info(" a only user with query method"+userRepository.findByEmailAndName("Ericka@domain.com", "Ericka")
		.orElseThrow( ()-> new RuntimeException("usuario no encontrado")));

	//	LOGGER.info("el usuario a partir del named parameter es: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(1970, 02, 12), "Ericka@domain.com" )
	//			.orElseThrow(()->new RuntimeException("no se encontro")));

      }

	private void saveUsersIndatabase(){
      	 User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 03, 20));
      	 User user2 = new User("Federico", "federico@domain.com", LocalDate.of(2021, 02, 12));
		User user3 = new User("Andrea", "andrea@domain.com", LocalDate.of(2019, 02, 12));
		User user4 = new User("Ericka", "Ericka@domain.com", LocalDate.of(1970, 02, 12));
		List<User> list = Arrays.asList(user1, user2, user3, user4);
		list.stream().forEach(userRepository::save);
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
