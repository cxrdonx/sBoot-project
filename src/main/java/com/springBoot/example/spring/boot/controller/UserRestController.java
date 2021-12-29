package com.springBoot.example.spring.boot.controller;

import com.springBoot.example.spring.boot.caseuse.CreateUser;
import com.springBoot.example.spring.boot.caseuse.DeleteUser;
import com.springBoot.example.spring.boot.caseuse.GetUser;
import com.springBoot.example.spring.boot.entity.User;
import org.hibernate.sql.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
      }

      @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
            return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
      }
      @DeleteMapping("/{id}")
    ResponseEntity userDelete(@PathVariable Long id){
                deleteUser.delete(id);
                return new ResponseEntity(HttpStatus.NO_CONTENT);
      }

}
