package org.example.controller;

import org.example.dao.EntrenadorDAOImp;
import org.example.dao.EquipoDAOImp;
import org.example.dao.JugadorDAOImp;
import org.example.dao.LigaDAOImp;
import org.example.model.Entrenador;
import org.example.model.Equipo;
import org.example.model.Jugador;
import org.example.model.Liga;

public class LigaController {

    private LigaDAOImp ligaDAOImp = new LigaDAOImp();
    private EntrenadorDAOImp entrenadorDAOImp = new EntrenadorDAOImp();
    private EquipoDAOImp equipoDAOImp = new EquipoDAOImp();
    private JugadorDAOImp jugadorDAOImp = new JugadorDAOImp();

    //fichaje de jugadores // busca al jugador y updatea el equipo.
    public void ficharJugador(int id_jugador, int id_equipo){
        jugadorDAOImp.ficharJugador(id_jugador, id_equipo);
    }
    //Listado de los equipos
    public void mostrarEquipos(){
        equipoDAOImp.mostrarEquipos();
    }
    // Mostrar los jugadores por equipo
    public void mostrarJugadoresPorEquipo (int id_equipo){
        equipoDAOImp.mostrarJugadoresEquipos(id_equipo);
    }
    //Muestra los equipos de una liga
    public void mostrarEquiposLiga(int id_liga){
        ligaDAOImp.mostrarEquiposLigaDAO (id_liga);
    }
    // Mostrar los entrenadores de una liga
    public void mostrarEntrenadoresLiga(int id_liga){
        ligaDAOImp.mostrarEntrenadoresLiga(id_liga);
    }

    public void inicializarDatos() {

        // -------------------- LIGAS --------------------
        Liga ligaEsp = new Liga("España", "15/08/2025", "25/06/2026");
        Liga ligaIta = new Liga("Italia", "07/08/2025", "26/06/2026");
        Liga ligaFra = new Liga("Francia", "01/08/2025", "15/06/2026");

        ligaDAOImp.insertarLiga(ligaEsp);
        ligaDAOImp.insertarLiga(ligaIta);
        ligaDAOImp.insertarLiga(ligaFra);

        // -------------------- ENTRENADORES --------------------
        Entrenador e1 = new Entrenador("Victor Perez", 94, 30);
        Entrenador e2 = new Entrenador("Jose Hernández", 85, 6);
        Entrenador e3 = new Entrenador("Marcos Rubio", 90, 8);
        Entrenador e4 = new Entrenador("Luis Enrique", 86, 9);
        Entrenador e5 = new Entrenador("Antonio Conte", 88, 12);
        Entrenador e6 = new Entrenador("Massimiliano Allegri", 85, 15);
        Entrenador e7 = new Entrenador("Stefano Pioli", 83, 4);
        Entrenador e8 = new Entrenador("Simone Inzaghi", 82, 6);
        Entrenador e9 = new Entrenador("Mauricio Pochettino", 87, 7);
        Entrenador e10 = new Entrenador("Rudi Garcia", 79, 3);
        Entrenador e11 = new Entrenador("Jorge Sampaoli", 81, 5);

        entrenadorDAOImp.insertarEntrenador(e1);
        entrenadorDAOImp.insertarEntrenador(e2);
        entrenadorDAOImp.insertarEntrenador(e3);
        entrenadorDAOImp.insertarEntrenador(e4);
        entrenadorDAOImp.insertarEntrenador(e5);
        entrenadorDAOImp.insertarEntrenador(e6);
        entrenadorDAOImp.insertarEntrenador(e7);
        entrenadorDAOImp.insertarEntrenador(e8);
        entrenadorDAOImp.insertarEntrenador(e9);
        entrenadorDAOImp.insertarEntrenador(e10);
        entrenadorDAOImp.insertarEntrenador(e11);

        // -------------------- EQUIPOS --------------------
        // España
        Equipo esp1 = new Equipo("Real Madrid", "Madrid", ligaEsp, e1);
        equipoDAOImp.insertarEquipo(esp1);
        Equipo esp2 = new Equipo("FC Barcelona", "Barcelona", ligaEsp, e2);
        equipoDAOImp.insertarEquipo(esp2);
        Equipo esp3 = new Equipo("Atlético de Madrid", "Madrid", ligaEsp, e3);
        equipoDAOImp.insertarEquipo(esp3);
        // Italia
        Equipo ita1 = new Equipo("Juventus", "Turín", ligaIta, e6);
        equipoDAOImp.insertarEquipo(ita1);
        Equipo ita2 = new Equipo("AC Milan", "Milán", ligaIta, e7);
        equipoDAOImp.insertarEquipo(ita2);
        Equipo ita3 = new Equipo("Inter", "Milán", ligaIta, e8);
        equipoDAOImp.insertarEquipo(ita3);

        // Francia
        Equipo fra1 = new Equipo("PSG", "París", ligaFra, e9);
        equipoDAOImp.insertarEquipo(fra1);
        Equipo fra2 = new Equipo("Olympique Lyon", "Lyon", ligaFra, e10);
        equipoDAOImp.insertarEquipo(fra2);
        Equipo fra3 = new Equipo("Olympique Marsella", "Marsella", ligaFra, e11);
        equipoDAOImp.insertarEquipo(fra3);


        // -------------------- JUGADORES --------------------

        // España - Real Madrid

        Jugador j1 = new Jugador("Jugador1_Real Madrid", "Portero", 600000, 2, "España", equipoDAOImp.selecionarEquipo(1), ligaEsp);
        jugadorDAOImp.insertarJugador(j1);
        Jugador j2 = new Jugador("Jugador2_Real Madrid", "Defensa", 700000, 4, "Argentina", equipoDAOImp.selecionarEquipo(1), ligaEsp);
        jugadorDAOImp.insertarJugador(j2);
        Jugador j3 = new Jugador("Jugador3_Real Madrid", "Medio", 800000, 6, "Brasil", equipoDAOImp.selecionarEquipo(1), ligaEsp);
        jugadorDAOImp.insertarJugador(j3);
        Jugador j4 = new Jugador("Jugador4_Real Madrid", "Delantero", 900000, 8, "Francia", equipoDAOImp.selecionarEquipo(1), ligaEsp);
        jugadorDAOImp.insertarJugador(j4);
        Jugador j5 = new Jugador("Jugador5_Real Madrid", "Portero", 1000000, 10, "Italia", equipoDAOImp.selecionarEquipo(1), ligaEsp);
        jugadorDAOImp.insertarJugador(j5);
        Jugador j6 = new Jugador("Jugador6_Real Madrid", "Defensa", 1100000, 12, "Portugal", equipoDAOImp.selecionarEquipo(1), ligaEsp);
        jugadorDAOImp.insertarJugador(j6);

// España - FC Barcelona
        Jugador j7 = new Jugador("Jugador1_FC Barcelona", "Portero", 600000, 2, "España", equipoDAOImp.selecionarEquipo(2), ligaEsp);
        jugadorDAOImp.insertarJugador(j7);
        Jugador j8 = new Jugador("Jugador2_FC Barcelona", "Defensa", 700000, 4, "Argentina", equipoDAOImp.selecionarEquipo(2), ligaEsp);
        jugadorDAOImp.insertarJugador(j8);
        Jugador j9 = new Jugador("Jugador3_FC Barcelona", "Medio", 800000, 6, "Brasil", equipoDAOImp.selecionarEquipo(2), ligaEsp);
        jugadorDAOImp.insertarJugador(j9);
        Jugador j10 = new Jugador("Jugador4_FC Barcelona", "Delantero", 900000, 8, "Francia", equipoDAOImp.selecionarEquipo(2), ligaEsp);
        jugadorDAOImp.insertarJugador(j10);
        Jugador j11 = new Jugador("Jugador5_FC Barcelona", "Portero", 1000000, 10, "Italia", equipoDAOImp.selecionarEquipo(2), ligaEsp);
        jugadorDAOImp.insertarJugador(j11);
        Jugador j12 = new Jugador("Jugador6_FC Barcelona", "Defensa", 1100000, 12, "Portugal", equipoDAOImp.selecionarEquipo(2), ligaEsp);
        jugadorDAOImp.insertarJugador(j12);

// España - Atlético de Madrid
        Jugador j13 = new Jugador("Jugador1_Atlético de Madrid", "Portero", 600000, 2, "España", equipoDAOImp.selecionarEquipo(3), ligaEsp);
        jugadorDAOImp.insertarJugador(j13);
        Jugador j14 = new Jugador("Jugador2_Atlético de Madrid", "Defensa", 700000, 4, "Argentina", equipoDAOImp.selecionarEquipo(3), ligaEsp);
        jugadorDAOImp.insertarJugador(j14);
        Jugador j15 = new Jugador("Jugador3_Atlético de Madrid", "Medio", 800000, 6, "Brasil", equipoDAOImp.selecionarEquipo(3), ligaEsp);
        jugadorDAOImp.insertarJugador(j15);
        Jugador j16 = new Jugador("Jugador4_Atlético de Madrid", "Delantero", 900000, 8, "Francia", equipoDAOImp.selecionarEquipo(3), ligaEsp);
        jugadorDAOImp.insertarJugador(j16);
        Jugador j17 = new Jugador("Jugador5_Atlético de Madrid", "Portero", 1000000, 10, "Italia", equipoDAOImp.selecionarEquipo(3), ligaEsp);
        jugadorDAOImp.insertarJugador(j17);
        Jugador j18 = new Jugador("Jugador6_Atlético de Madrid", "Defensa", 1100000, 12, "Portugal", equipoDAOImp.selecionarEquipo(3), ligaEsp);
        jugadorDAOImp.insertarJugador(j18);

// Italia - Juventus
        Jugador j19 = new Jugador("Jugador1_Juventus", "Portero", 600000, 2, "Italia", equipoDAOImp.selecionarEquipo(4), ligaIta);
        jugadorDAOImp.insertarJugador(j19);
        Jugador j20 = new Jugador("Jugador2_Juventus", "Defensa", 700000, 4, "Argentina", equipoDAOImp.selecionarEquipo(4), ligaIta);
        jugadorDAOImp.insertarJugador(j20);
        Jugador j21 = new Jugador("Jugador3_Juventus", "Medio", 800000, 6, "Brasil", equipoDAOImp.selecionarEquipo(4), ligaIta);
        jugadorDAOImp.insertarJugador(j21);
        Jugador j22 = new Jugador("Jugador4_Juventus", "Delantero", 900000, 8, "Francia", equipoDAOImp.selecionarEquipo(4), ligaIta);
        jugadorDAOImp.insertarJugador(j22);
        Jugador j23 = new Jugador("Jugador5_Juventus", "Portero", 1000000, 10, "España", equipoDAOImp.selecionarEquipo(4), ligaIta);
        jugadorDAOImp.insertarJugador(j23);
        Jugador j24 = new Jugador("Jugador6_Juventus", "Defensa", 1100000, 12, "Portugal", equipoDAOImp.selecionarEquipo(4), ligaIta);
        jugadorDAOImp.insertarJugador(j24);

// Italia - AC Milan
        Jugador j25 = new Jugador("Jugador1_AC Milan", "Portero", 600000, 2, "Italia", equipoDAOImp.selecionarEquipo(5), ligaIta);
        jugadorDAOImp.insertarJugador(j25);
        Jugador j26 = new Jugador("Jugador2_AC Milan", "Defensa", 700000, 4, "Argentina", equipoDAOImp.selecionarEquipo(5), ligaIta);
        jugadorDAOImp.insertarJugador(j26);
        Jugador j27 = new Jugador("Jugador3_AC Milan", "Medio", 800000, 6, "Brasil", equipoDAOImp.selecionarEquipo(5), ligaIta);
        jugadorDAOImp.insertarJugador(j27);
        Jugador j28 = new Jugador("Jugador4_AC Milan", "Delantero", 900000, 8, "Francia", equipoDAOImp.selecionarEquipo(5), ligaIta);
        jugadorDAOImp.insertarJugador(j28);
        Jugador j29 = new Jugador("Jugador5_AC Milan", "Portero", 1000000, 10, "España", equipoDAOImp.selecionarEquipo(5), ligaIta);
        jugadorDAOImp.insertarJugador(j29);
        Jugador j30 = new Jugador("Jugador6_AC Milan", "Defensa", 1100000, 12, "Portugal", equipoDAOImp.selecionarEquipo(5), ligaIta);
        jugadorDAOImp.insertarJugador(j30);

// Italia - Inter
        Jugador j31 = new Jugador("Jugador1_Inter", "Portero", 600000, 2, "Italia", equipoDAOImp.selecionarEquipo(6), ligaIta);
        jugadorDAOImp.insertarJugador(j31);
        Jugador j32 = new Jugador("Jugador2_Inter", "Defensa", 700000, 4, "Argentina", equipoDAOImp.selecionarEquipo(6), ligaIta);
        jugadorDAOImp.insertarJugador(j32);
        Jugador j33 = new Jugador("Jugador3_Inter", "Medio", 800000, 6, "Brasil", equipoDAOImp.selecionarEquipo(6), ligaIta);
        jugadorDAOImp.insertarJugador(j33);
        Jugador j34 = new Jugador("Jugador4_Inter", "Delantero", 900000, 8, "Francia", equipoDAOImp.selecionarEquipo(6), ligaIta);
        jugadorDAOImp.insertarJugador(j34);
        Jugador j35 = new Jugador("Jugador5_Inter", "Portero", 1000000, 10, "España", equipoDAOImp.selecionarEquipo(6), ligaIta);
        jugadorDAOImp.insertarJugador(j35);
        Jugador j36 = new Jugador("Jugador6_Inter", "Defensa", 1100000, 12, "Portugal", equipoDAOImp.selecionarEquipo(6), ligaIta);
        jugadorDAOImp.insertarJugador(j36);

// Francia - PSG
        Jugador j37 = new Jugador("Jugador1_PSG", "Portero", 600000, 2, "Francia", equipoDAOImp.selecionarEquipo(7), ligaFra);
        jugadorDAOImp.insertarJugador(j37);
        Jugador j38 = new Jugador("Jugador2_PSG", "Defensa", 700000, 4, "Italia", equipoDAOImp.selecionarEquipo(7), ligaFra);
        jugadorDAOImp.insertarJugador(j38);
        Jugador j39 = new Jugador("Jugador3_PSG", "Medio", 800000, 6, "España", equipoDAOImp.selecionarEquipo(7), ligaFra);
        jugadorDAOImp.insertarJugador(j39);
        Jugador j40 = new Jugador("Jugador4_PSG", "Delantero", 900000, 8, "Portugal", equipoDAOImp.selecionarEquipo(7), ligaFra);
        jugadorDAOImp.insertarJugador(j40);
        Jugador j41 = new Jugador("Jugador5_PSG", "Portero", 1000000, 10, "Argentina", equipoDAOImp.selecionarEquipo(7), ligaFra);
        jugadorDAOImp.insertarJugador(j41);
        Jugador j42 = new Jugador("Jugador6_PSG", "Defensa", 1100000, 12, "Brasil", equipoDAOImp.selecionarEquipo(7), ligaFra);
        jugadorDAOImp.insertarJugador(j42);

// Francia - Olympique Lyon
        Jugador j43 = new Jugador("Jugador1_Olympique Lyon", "Portero", 600000, 2, "Francia", equipoDAOImp.selecionarEquipo(8), ligaFra);
        jugadorDAOImp.insertarJugador(j43);
        Jugador j44 = new Jugador("Jugador2_Olympique Lyon", "Defensa", 700000, 4, "Italia", equipoDAOImp.selecionarEquipo(8), ligaFra);
        jugadorDAOImp.insertarJugador(j44);
        Jugador j45 = new Jugador("Jugador3_Olympique Lyon", "Medio", 800000, 6, "España", equipoDAOImp.selecionarEquipo(8), ligaFra);
        jugadorDAOImp.insertarJugador(j45);
        Jugador j46 = new Jugador("Jugador4_Olympique Lyon", "Delantero", 900000, 8, "Portugal", equipoDAOImp.selecionarEquipo(8), ligaFra);
        jugadorDAOImp.insertarJugador(j46);
        Jugador j47 = new Jugador("Jugador5_Olympique Lyon", "Portero", 1000000, 10, "Argentina", equipoDAOImp.selecionarEquipo(8), ligaFra);
        jugadorDAOImp.insertarJugador(j47);
        Jugador j48 = new Jugador("Jugador6_Olympique Lyon", "Defensa", 1100000, 12, "Brasil", equipoDAOImp.selecionarEquipo(8), ligaFra);
        jugadorDAOImp.insertarJugador(j48);

// Francia - Olympique Marsella
        Jugador j49 = new Jugador("Jugador1_Olympique Marsella", "Portero", 600000, 2, "Francia", equipoDAOImp.selecionarEquipo(9), ligaFra);
        jugadorDAOImp.insertarJugador(j49);
        Jugador j50 = new Jugador("Jugador2_Olympique Marsella", "Defensa", 700000, 4, "Italia", equipoDAOImp.selecionarEquipo(9), ligaFra);
        jugadorDAOImp.insertarJugador(j50);
        Jugador j51 = new Jugador("Jugador3_Olympique Marsella", "Medio", 800000, 6, "España", equipoDAOImp.selecionarEquipo(9), ligaFra);
        jugadorDAOImp.insertarJugador(j51);
        Jugador j52 = new Jugador("Jugador4_Olympique Marsella", "Delantero", 900000, 8, "Portugal", equipoDAOImp.selecionarEquipo(9), ligaFra);
        jugadorDAOImp.insertarJugador(j52);
        Jugador j53 = new Jugador("Jugador5_Olympique Marsella", "Portero", 1000000, 10, "Argentina", equipoDAOImp.selecionarEquipo(9), ligaFra);
        jugadorDAOImp.insertarJugador(j53);
        Jugador j54 = new Jugador("Jugador6_Olympique Marsella", "Defensa", 1100000, 12, "Brasil", equipoDAOImp.selecionarEquipo(9), ligaFra);
        jugadorDAOImp.insertarJugador(j54);



    }

}
