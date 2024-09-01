package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@IdClass(DetalleAsistenciaId.class)
@Table(name = "detalle_asistencia")
public class DetalleAsistencia{
    
    private static final long serialVersionUID = 1L;

    
    private boolean esta_presente = true;
    private LocalTime hora_presencia;
    private String rasgos= "";
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_asistencia")
    private Asistencia asistencia;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
     
}
