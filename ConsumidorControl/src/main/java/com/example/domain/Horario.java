package com.example.domain;

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
@Entity
@Table(name = "horario")
public class Horario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_horario;
    private int seccion;
    private Time hora_inicio;
    private Time hora_fin;
    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad id_especialidad;
    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala id_sala;
    @ManyToOne
    @JoinColumn(name = "id_profesor")  
    private Profesor id_profesor;
}
