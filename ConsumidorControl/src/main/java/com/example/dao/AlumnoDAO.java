/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.dao;

import com.example.domain.Alumno;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anibal
 */
public interface AlumnoDAO extends CrudRepository<Alumno, Long> {

    
}
