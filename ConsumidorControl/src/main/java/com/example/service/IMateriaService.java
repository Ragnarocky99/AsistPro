
package com.example.service;

import com.example.model.Materia;
import java.util.List;

public interface IMateriaService {
    
    List<Materia> listarMaterias();
    void eliminarMateria(int id);
    void guardarMateria(Materia materia);
    Materia buscarMateriaPorId(int id);
}
