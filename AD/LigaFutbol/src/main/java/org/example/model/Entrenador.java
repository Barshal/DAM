package org.example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="entrenadores")

public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entrenador;
    private String nombre;
    private int calificacion;
    private int titulos;

    public Entrenador(String nombre, int calificacion, int titulos) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulos = titulos;
    }
}
