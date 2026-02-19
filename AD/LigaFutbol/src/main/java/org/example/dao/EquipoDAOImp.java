package org.example.dao;

import org.example.model.Equipo;
import org.example.model.Jugador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EquipoDAOImp implements EquipoDAO {

    private Session session;
    private Transaction transaction;

    @Override
    public void insertarEquipo(Equipo equipo){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        session.merge(equipo);

        transaction.commit();
        session.close();
    }

    @Override
    public Equipo selecionarEquipo(int id_equipo){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Equipo equipo = new Equipo();
        equipo = session.find(Equipo.class, id_equipo);

        session.close();
        return equipo;
    }

    @Override
    public void mostrarEquipos() {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Query<Equipo> query = session.createQuery("FROM Equipo",Equipo.class);
        List<Equipo> equipoResultantes = query.getResultList();

        for (Equipo item: equipoResultantes){
            System.out.println(item.getId_equipo() + " " + item.getNombre());
        }

        session.close();
    }

    @Override
    public void mostrarJugadoresEquipos(int id_equipo){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Equipo equipo = new Equipo();
        equipo = session.find(Equipo.class, id_equipo);

        if(equipo != null){
            System.out.println("Jugadores del equipo " + equipo.getNombre());

            for (Jugador j: equipo.getJugadores()){
                System.out.println("  - " + j.getNombre() +", " + j.getPosicion());
            }
        }else {
            System.out.println("No se ha podido recuperar los jugadores");
        }
        session.close();
    }
}
