
package com.example.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Time;
import lombok.Data;

@Data
@Table(name = "detalle_asistencia")
public class DetalleAsistencia {
    
    private boolean esta_presente;
    private Time hora_presencia;
    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
}
