package com.example.service;

import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import java.util.List;
import java.util.Optional;

public interface IDetalleAsistenciaService {
    List<DetalleAsistencia> listarDetalles();
    void borrarDetalle(DetalleAsistenciaId id);
    DetalleAsistencia localizarDetalleporId(DetalleAsistenciaId id);
    void guardarDetalle(DetalleAsistencia detalle);
    List<DetalleAsistencia> listarDetallesPorAsistencia(int idAsistencia);
    DetalleAsistencia localizarDetallePorAlumnoYAsistencia(int idAsistencia,int idAlumno);
    Optional<DetalleAsistencia> localizarDetalleporIdd(DetalleAsistenciaId id);
    void borrarrasgo(int IdAsistencia, int idAlumno);
     
    DetalleAsistencia buscarAsistenciaDeAlumno(int idAlumno, int idAsistencia);
    List<DetalleAsistencia> buscarDetallesPorAsistencia(int idasis);

}
