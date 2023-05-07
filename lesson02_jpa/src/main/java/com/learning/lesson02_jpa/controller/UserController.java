package com.learning.lesson02_jpa.controller;

import com.learning.lesson02_jpa.model.User;
import com.learning.lesson02_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("get/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id){
        try {
            User user = userRepository.findById(id).get();
            return new ResponseEntity<>(user,  HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
