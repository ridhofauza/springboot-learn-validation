/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.learnvalidation.repository;

import com.example.learnvalidation.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUserId(int id);
}
