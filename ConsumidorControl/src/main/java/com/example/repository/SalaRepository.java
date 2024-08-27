package com.example.repository;

import com.example.model.LectorHuella;
import com.example.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
    Sala findSalaByLector(LectorHuella lector);
}
