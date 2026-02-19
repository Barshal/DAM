package org.example.dao;

import org.example.model.Entrenador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EntrenadorDAOImp implements EntrenadorDAO {
    private Session session;
    private Transaction transaction;

    @Override
    public void insertarEntrenador(Entrenador entrenador) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        session.persist(entrenador);


        transaction.commit();
        session.close();
    }
}
