/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.learnvalidation.controller;

import com.example.learnvalidation.dto.UserRequest;
import com.example.learnvalidation.entity.User;
import com.example.learnvalidation.exception.UserNotFoundException;
import com.example.learnvalidation.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService service;
    
    @PostMapping("/signup")
    public ResponseEntity<User>saveUser(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }
    
    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(service.getAllUsers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }
    
}
