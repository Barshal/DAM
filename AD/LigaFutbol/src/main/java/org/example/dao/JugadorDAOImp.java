package org.example.dao;

import org.example.model.Equipo;
import org.example.model.Jugador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JugadorDAOImp implements JugadorDAO{

    private Session session;
    private Transaction transaction;

    @Override
    public void insertarJugador(Jugador jugador){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        session.persist(jugador);

        transaction.commit();
        session.close();
    }
    @Override
    public void ficharJugador(int id_jugador, int id_equipo){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();


        Equipo equipo = session.find(Equipo.class, id_equipo);
        Jugador jugador = session.find(Jugador.class, id_jugador);

        if(jugador != null && equipo != null){
            jugador.setEquipo(equipo);
            System.out.println("Fichado conrrectamente");
        } else {
            System.out.println("No se finalizar el fichaje");
        }
        transaction.commit();
        session.close();
    }

//    @Override
//    public void mostrarJugadoresPorEquipo(int id_equipo){
//        session = new Configuration().configure().buildSessionFactory().openSession();
//        transaction = session.beginTransaction();
//
//
//
//        session.close();
//    }

}
