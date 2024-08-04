package com.example.repository;

import com.example.model.Profesor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
    @Query("SELECT p FROM Profesor p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT(:nombre, '%'))")
    List<Profesor> findByNombre(String nombre);
}
