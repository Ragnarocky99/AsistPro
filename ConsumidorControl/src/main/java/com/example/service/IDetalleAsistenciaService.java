package com.example.service;

import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import java.util.List;

public interface IDetalleAsistenciaService {
    List<DetalleAsistencia> listarDetalles();
    void borrarDetalle(DetalleAsistenciaId id);
    DetalleAsistencia localizarDetalleporId(DetalleAsistenciaId id);
    void guardarDetalle(DetalleAsistencia detalle);
    List<DetalleAsistencia> listarDetallesPorAsistencia(int idAsistencia);
    
}
