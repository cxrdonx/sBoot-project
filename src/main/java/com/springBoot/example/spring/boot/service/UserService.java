package com.springBoot.example.spring.boot.service;

import com.springBoot.example.spring.boot.entity.User;
import com.springBoot.example.spring.boot.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream().peek(user -> LOG.info("User insert: "+ user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User newUser) {
         return userRepository.save(newUser);
    }


    public void delete(Long id) {
        userRepository.delete(new User(id));
    }
}
