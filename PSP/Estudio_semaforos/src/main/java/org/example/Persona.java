package org.example;

import java.util.concurrent.Semaphore;

public class Persona extends Thread{

    private static Semaphore salaEspera = new Semaphore(5);
    private static Semaphore salaDonacion = new Semaphore(1);

    private int id = 0;
    private static double donacion = 0;
    private int tiempoEspera = (int)(Math.random() * 3 + 1);

    public Persona(int id) {
        this.id = id;
    }

    public void donar(){
        // Entran a la sala de espera de que tiene un limiete de 5
        try {
            salaEspera.acquire();
            System.out.printf("%s - Entra sala de espera",id);
            Thread.sleep(tiempoEspera * 1000);

            // Entra en sala de donacion
                salaDonacion.acquire();
                System.out.printf("%s - Entra a donacion",id);
                Thread.sleep(tiempoEspera * 1000);
                salaDonacion.release();
                donacion += tiempoEspera * 10;
                System.out.printf("%s - Sale de donacion",id);

            salaEspera.release();
            System.out.printf("%s - Termina el proceso",id);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void run(){
        donar();
    }

    public void mostradDonacion(){
        System.out.println("Dinero donado = " + donacion);
    }
}
