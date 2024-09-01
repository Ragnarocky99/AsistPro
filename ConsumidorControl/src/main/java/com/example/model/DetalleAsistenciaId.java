package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class DetalleAsistenciaId implements Serializable {
    private int asistencia;
    private int alumno;
    
                            
    public DetalleAsistenciaId(int asistencia, int alumno) {
        this.asistencia = asistencia;
        this.alumno = alumno;
    }

    public DetalleAsistenciaId(int asistencia) {
        this.asistencia = asistencia;
    }
    
    
    
    // Default constructor
    public DetalleAsistenciaId() {}

    // Getters and setters
    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }
    
    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleAsistenciaId that = (DetalleAsistenciaId) o;
        return Objects.equals(asistencia, that.asistencia) && Objects.equals(alumno, that.alumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asistencia, alumno);
    }
}
