package com.example.liga_trail_running.model;

import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
@Getter
@Setter
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer dorsal;
    private String tiempoOficial;

    @ManyToOne
    @JoinColumn(name = "corredor_id")
    private Corredor corredor;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    // getters y setters
}

