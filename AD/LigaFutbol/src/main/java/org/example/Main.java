package org.example;

import org.example.controller.LigaController;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        LigaController ligaController = new LigaController();
        Scanner scanner = new Scanner(System.in);


        // Lanza una primera version de datos para poder ejecutar despues las operaciones.
        ligaController.inicializarDatos();

        // REalizamos fuchacjes, para ello damos id de jugador y del equipo para que el metodo busque las entidades y ya opere la
        // transaccion
        ligaController.ficharJugador(1,5);
        ligaController.ficharJugador(2,3);
        // Si el equipo no existe no hace el update y te avisa
        ligaController.ficharJugador(3,10);

        //Muestra datos de todos los equipos
        //
        ligaController.mostrarEquipos();

        // Muestra los jugadores de un equipo
        ligaController.mostrarJugadoresPorEquipo(2);

        //Muestra los equipos de una liga
        ligaController.mostrarEquiposLiga(1);

        // Muestra todos los entrenadores de los equipos de una liga
        ligaController.mostrarEntrenadoresLiga(1);

    }
}