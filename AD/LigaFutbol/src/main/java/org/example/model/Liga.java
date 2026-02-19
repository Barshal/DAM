package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Se va a tratar de una entidad de base de datos
@Table(name = "ligas") // Utilizar cuando el nombre de la clase es diferentes al nombre de la tabla
@NamedQuery(name = "Liga.findbyFechaInicio", query = "FROM Liga l WHERE l.fecha_inicio = :fechaInicioArgs")

public class Liga {
    @Id // Para indicar que es la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Cuando se persiste, no lo incluye para que la BBDD lo haga en caso de se autoincremental
    private int id_liga;
    @Column(name = "nombre_liga") // Indica que este atributo va mapeado contra bbdd
    private String nombre_liga;
    @Column // Indica que este atributo va mapeado contra bbdd
    private String fecha_inicio;
    @Column // Indica que este atributo va mapeado contra bbdd
    private String fecha_fin;
    // Lista de equipos que apntan a la liga
    @OneToMany(mappedBy = "liga", fetch = FetchType.LAZY)
    private List<Equipo> equipos;


    public Liga(String nombre_liga, String fecha_inicio, String getFecha_inicio) {
        this.nombre_liga = nombre_liga;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = getFecha_inicio;
    }

    public void mostrarDatosLiga(){
        System.out.println("ID Liga: " + id_liga);
        System.out.println("Nombre Liga: " + nombre_liga);
        System.out.println("Fecha Inicio: " + fecha_inicio);
        System.out.println("Fecha Fin: " + fecha_fin);
        if (equipos != null && !equipos.isEmpty()) {
            System.out.println("Equipos en la liga:");
            for (Equipo equipo : equipos) {
                System.out.println("  - " + equipo.getNombre());
            }
        } else {
            System.out.println("Liga sin equipos.");
        }
    }
    public void mostrarDatosEntrenador(){
        System.out.println("ID Liga: " + id_liga);
        System.out.println("Nombre Liga: " + nombre_liga);
        System.out.println("Fecha Inicio: " + fecha_inicio);
        System.out.println("Fecha Fin: " + fecha_fin);
        if (equipos != null && !equipos.isEmpty()) {
            System.out.println("Entrenadores en la liga:");
            for (Equipo equipo : equipos) {
                System.out.println("  - " + equipo.getNombre() + " ->" + equipo.getEntrenador().getNombre());
            }
        } else {
            System.out.println("No se han podido recuperar los entrenadores.");
        }
    }
}
