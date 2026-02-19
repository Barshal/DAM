package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jugadores")

public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jugador;
    private String nombre;
    private String posicion;
    private double valor_mercado;
    private int goles;
    private String nacionalidad;
    // Relacion unidireccional
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name= "id_equipo")
    private Equipo equipo;
    // Relacion unidireccional
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name= "id_liga")
    private Liga liga;

    public Jugador(String nombre, String posicion, double valor_mercado, int goles, String nacionalidad,Equipo equipo ,Liga liga) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.valor_mercado = valor_mercado;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
        this.liga = liga;
    }
}
