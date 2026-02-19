package org.example.dao;

import org.example.model.Liga;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class LigaDAOImp implements LigaDAO {
    private Session session;
    private Transaction transaction;

    @Override
    public void selecionarLiga(int id_liga){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Liga liga = new Liga();
        liga = session.find(Liga.class, id_liga);
        System.out.println(liga.getNombre_liga());

        session.close();
    }
    @Override
    public void insertarLiga(Liga liga){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            session.persist(liga);
            System.out.println("Liga creada correctamente");
        } catch (Exception e) {
            System.out.println("No se ha podido insertar la liga");
        }

        transaction.commit();
        session.close();
    }
    @Override
    public void borrarLigaId(int id_liga){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Liga liga = session.find(Liga.class, id_liga);
        if (liga != null){
            session.remove(liga);
            System.out.println("La liga se ha borrado correctamente");
        } else {
            System.out.println("La liga no se encuentra");
        }

        transaction.commit();
        session.close();
    }
    @Override
    public void actualizarLigaNombre(int id_liga, String nombre_nuevo){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Liga liga = session.find(Liga.class, id_liga);
             if(liga != null ){
                 liga.setNombre_liga(nombre_nuevo);
                 System.out.println("Nombre cambiado correctamenet");
             } else {
                 System.out.println("No se ha podido actualizar el nombre");
                 }
        transaction.commit();
        session.close();
    }
    @Override
    public void seleccionarLigas(){
        // CriteriaQuery MutationQuery(HQL - JPQL) - SQL
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Query<Liga> query = session.createQuery("FROM Liga",Liga.class);
        List<Liga> listaResultante = query.getResultList();

        for (Liga item: listaResultante){
            System.out.println(item.getId_liga() + " " + item.getNombre_liga());
        }

        transaction.commit();
        session.close();
    }
    @Override
    public void seleccionarPorNombre(String nombre){
        // CriteriaQuery MutationQuery(HQL - JPQL) - SQL
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Query<Liga> query = session.createQuery("FROM Liga l WHERE l.nombre_liga = :nombreArgs",Liga.class);
        query.setParameter("nombreArgs",nombre);

        List<Liga> listaResultante = query.getResultList();

        for (Liga item: listaResultante){
            System.out.println(item.getId_liga() + " " + item.getNombre_liga());
        }

        transaction.commit();
        session.close();
    }
    @Override
    public void seleccionarPorFecha(String fecha){
        // CriteriaQuery MutationQuery(HQL - JPQL) - SQL
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Query<Liga> query = session.createNamedQuery("Liga.findbyFechaInicio", Liga.class);
        query.setParameter("fechaInicioArgs",fecha);

        List<Liga> listaResultante = query.getResultList();

        for (Liga item: listaResultante){
            System.out.println(item.getId_liga() + " " + item.getNombre_liga());
        }

        transaction.commit();
        session.close();
    }

    @Override
    public void mostrarEquiposLigaDAO(int id_liga){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Liga liga = new Liga();
        liga = session.find(Liga.class, id_liga);
        liga.mostrarDatosLiga();

        transaction.commit();
        session.close();
    }

    @Override
    public void mostrarEntrenadoresLiga(int id_liga){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Liga liga = new Liga();
        liga = session.find(Liga.class, id_liga);
        liga.mostrarDatosEntrenador();

        transaction.commit();
        session.close();
    }
}
