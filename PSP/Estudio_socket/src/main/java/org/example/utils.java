package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class utils {
    public static String leerArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Lee la primera línea
            System.out.println("Numero leido correctamente.");
            return br.readLine();
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
        return "error"; // Valor por defecto si algo falla
    }

}
