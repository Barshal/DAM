package com.javafx_profesor.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AsignaturaAlumno {
    private int id;
    private String modulo;
    private double nota;
    private String alumno;
}
