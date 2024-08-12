package com.example.service;

import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import com.example.repository.DetalleAsistenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleAsistenciaServiceImplement implements IDetalleAsistenciaService{
    
    @Autowired
    private DetalleAsistenciaRepository detalleRepo;

    @Override
    public List<DetalleAsistencia> listarDetalles() {
        return detalleRepo.findAll();
    }


    @Override
    public void guardarDetalle(DetalleAsistencia detalle) {
        detalleRepo.save(detalle);
    }

    @Override
    public void borrarDetalle(DetalleAsistenciaId id) {
        detalleRepo.deleteById(id);
    }

    @Override
    public DetalleAsistencia localizarDetalleporId(DetalleAsistenciaId id) {
        return detalleRepo.findById(id).orElse(null);
    }

    @Override
    public List<DetalleAsistencia> listarDetallesPorAsistencia(int idAsistencia) {
        return detalleRepo.findDetallesAsistencia(idAsistencia);
    }
    
}
