package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipos")

public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_equipo;
    @Column(name = "nombre_equipo")
    private String nombre;
    private String ciudad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name= "id_liga")
    private Liga liga;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name= "id_entrenador")
    private Entrenador entrenador;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY)
    private List<Jugador> jugadores = new ArrayList<>();


    public Equipo(String nombre, String ciudad, Liga liga, Entrenador entrenador) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.liga = liga;
        this.entrenador = entrenador;
    }

    public void mostrarDatosEquipos(){
        System.out.println("Equipo: " + getNombre());
    }
}
