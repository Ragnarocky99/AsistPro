package com.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private long id_alumno;
    private String nombre;
    private String apellido;
    private String curso;
    private String seccion;
    private String cdi;
    private long id_especialidad;
    private String estado;

    public Alumno(long id_alumno, String nombre, String apellido, String curso, String seccion, String cdi, long id_especialidad, String estado) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.seccion = seccion;
        this.cdi = cdi;
        this.id_especialidad = id_especialidad;
        this.estado = estado;
    }
    
    
    
}
