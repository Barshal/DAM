package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Estructura de datos para manejar los hilos
        ArrayList<Thread> listaPersonas = new ArrayList<Thread>();
        // Creo las personas que heredan de Thread
        Persona p1 = new Persona("Hector",1);
        Persona p2 = new Persona("Ana",2);
        Persona p3 = new Persona("Carmen",3);

        // Creo los animales que implementan Runneable
        Animal a1 = new Animal("Neva",1);
        Animal a2 = new Animal("Gatito",2);
        Animal a3 = new Animal("Pajarito",3);

        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);

        listaPersonas.add(new Thread(a1));
        listaPersonas.add(new Thread(a2));
        listaPersonas.add(new Thread(a3));

        for (Thread thread : listaPersonas) {
            thread.start();
        }

        // Con join se fuerza a tener un punto de espera para todos los hilos hasta que terminen
        for(Thread thread : listaPersonas){
            thread.join();
        }
    }
}