/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.learnvalidation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
@Entity
@Table(name = "users_tbl")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;
}
