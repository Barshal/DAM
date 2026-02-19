package org.example.dao;

import org.example.model.Equipo;

public interface EquipoDAO {
    void insertarEquipo(Equipo equipo);

    Equipo selecionarEquipo(int id_equipo);

    void mostrarEquipos();

    void mostrarJugadoresEquipos(int id_equipo);
}
