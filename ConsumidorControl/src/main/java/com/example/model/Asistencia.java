package com.example.model;

import com.example.model.Horario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asistencia;
    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;
    private LocalDate fecha;
    @OneToMany(mappedBy = "asistencia")
    private Set<DetalleAsistencia> detalleAsistencia;
}