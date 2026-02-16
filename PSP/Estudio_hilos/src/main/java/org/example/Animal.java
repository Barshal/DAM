package org.example;

public class Animal implements Runnable{
    private String nombre;
    private int tiempoEspera;

    public Animal(String nombre, int tiempoEspera) {
        this.nombre = nombre;
        this.tiempoEspera = tiempoEspera;
    }

    private void comer(){
        try {
            System.out.println();
            System.out.printf("%s ha empezado a comer", nombre);
            Thread.sleep(tiempoEspera * 1000);
            System.out.printf("%s ha terminado de comer", nombre);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        comer();
    }
}
