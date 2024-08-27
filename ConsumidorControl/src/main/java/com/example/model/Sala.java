
package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "sala")
public class Sala implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sala;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_lector")
    private LectorHuella lector;
    @ManyToMany
    @JoinTable(
    name = "salas_por_enfasis",
    inverseJoinColumns = @JoinColumn(name = "id_enfasis"))
    private Set<Enfasis> enfasis;
            
    
}
