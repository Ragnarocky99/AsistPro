/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.repository;

import com.example.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nahue
 */
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
    
    public AppUser findByEmail(String email);
    
}
