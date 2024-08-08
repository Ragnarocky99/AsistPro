package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Time;
import lombok.Data;

@Data
@Table(name = "detalle_asistencia")
public class DetalleAsistencia {
    
    private static final long serialVersionUID = 1L;

    
    private boolean esta_presente;
    private Time hora_presencia;
    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
}
