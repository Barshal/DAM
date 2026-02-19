package com.javafx_actividad_entregable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
    private String nombre = "Hector";
    private String apellidos = "Lopez Olmos";
    private String codigoUem = "98JNDFAS2398";
    private String curso = "2025/2026";
    private String localidad = "Madrid";
    private String centro = "UEM Madrid";
}
