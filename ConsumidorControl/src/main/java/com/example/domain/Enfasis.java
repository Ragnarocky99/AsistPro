package com.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "enfasis")
public class Enfasis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_enfasis;
    private String nombre;
    
    @ManyToMany(mappedBy = "enfasis")
    private Set<Sala> salas;
}
