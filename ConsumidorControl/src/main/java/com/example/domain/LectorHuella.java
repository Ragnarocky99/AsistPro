
package com.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lector_huella")
public class LectorHuella {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lector;
}
