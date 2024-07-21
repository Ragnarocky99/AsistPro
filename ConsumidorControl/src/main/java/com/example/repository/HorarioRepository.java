package com.example.repository;

import com.example.model.Horario;
import org.springframework.data.repository.CrudRepository;

public interface HorarioRepository extends CrudRepository<Horario, Integer> {
    
}
