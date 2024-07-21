package com.example.model;

import com.example.model.Especialidad;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alumno;
    private String nombre;
    private String apellido;
    private String curso;
    private Integer seccion;
    private String cdi;
    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;
    private String estado;
 
}
