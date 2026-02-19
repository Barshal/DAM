package org.example.dao;

import org.example.model.Jugador;

public interface JugadorDAO {
    void insertarJugador(Jugador jugador);

    void ficharJugador(int id_jugador, int id_equipo);
}
