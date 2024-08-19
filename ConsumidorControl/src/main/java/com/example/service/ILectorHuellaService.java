package com.example.service;

import com.example.model.LectorHuella;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILectorHuellaService {
    List<LectorHuella> listarLectores();
    void guardarLector(LectorHuella lector);
    void borrarLector(int id);
    LectorHuella buscarLector(int id);
    
    
}
