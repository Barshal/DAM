package com.javafx_alumno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private int id = 1;
    private String nombre = "Hector", apellidos = "Lopez Olmos", expediente = "UEM256DF45";
}
