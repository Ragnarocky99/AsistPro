package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.Individuo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface IndividuoDao extends CrudRepository<Individuo, Long> {
    
    @Query("SELECT i FROM Individuo i WHERE LOWER(i.nombre) LIKE LOWER(CONCAT(:nombre, '%'))")
    List<Individuo> findByNombre(String nombre);
    
    
}
