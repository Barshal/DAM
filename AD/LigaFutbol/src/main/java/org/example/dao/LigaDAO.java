package org.example.dao;

import org.example.model.Liga;

public interface LigaDAO {

    void selecionarLiga(int id_liga);

    void insertarLiga(Liga liga);

    void borrarLigaId(int id_liga);

    void actualizarLigaNombre(int id_liga, String nombre_nuevo);

    void seleccionarLigas();

    void seleccionarPorNombre(String nombre);

    void seleccionarPorFecha(String fecha);

    void mostrarEquiposLigaDAO(int id_liga);

    void mostrarEntrenadoresLiga(int id_liga);
}
