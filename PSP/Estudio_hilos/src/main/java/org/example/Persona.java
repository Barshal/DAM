package org.example;

public class Persona extends Thread{
    private String nombre;
    private int tiempoEspera;

    public Persona(String nombre, int tiempoEspera) {
        this.nombre = nombre;
        this.tiempoEspera = tiempoEspera;
    }

    public void run(){
        try {
            System.out.println("");
            System.out.printf("%s ha empezaro a comer",nombre);
            Thread.sleep(tiempoEspera *1000) ;
            System.out.println("");
            System.out.printf("%s ha terminado de comer",nombre);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
