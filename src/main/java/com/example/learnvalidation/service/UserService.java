/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.learnvalidation.service;

import com.example.learnvalidation.dto.UserRequest;
import com.example.learnvalidation.entity.User;
import com.example.learnvalidation.exception.UserNotFoundException;
import com.example.learnvalidation.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public User saveUser(UserRequest userRequest) {
        User user = User
            .build(0, userRequest.getName(), userRequest.getEmail(), 
                userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), 
                userRequest.getNationality());
        return repository.save(user);
    }
    
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    
    public User getUser(int id) throws UserNotFoundException {
        return  repository.findByUserId(id)
            .orElseThrow(() -> new UserNotFoundException("User not found with id: "+id));
    }
    
}
