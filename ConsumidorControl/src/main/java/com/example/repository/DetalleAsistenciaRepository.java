package com.example.repository;

import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleAsistenciaRepository extends JpaRepository<DetalleAsistencia, DetalleAsistenciaId> {
    // Usar el nombre de la entidad y su propiedad
    @Query(value = "SELECT * FROM detalle_asistencia d WHERE d.id_asistencia = :idAsistencia", nativeQuery = true)
    List<DetalleAsistencia> findDetallesAsistencia(@Param("idAsistencia") int idAsistencia);
}

