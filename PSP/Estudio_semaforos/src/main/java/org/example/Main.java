package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> listaPersonas = new ArrayList<Thread>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Indica el numero de personas: ");
        System.out.println();

        int numPersonas = scanner.nextInt();

        for (int i = 0; i < numPersonas; i++) {
            Persona persona = new Persona(i);
            listaPersonas.add(persona);
        }

        for(Thread thread : listaPersonas){
            thread.start();
        }

        for(Thread thread : listaPersonas){
            thread.join();
        }

    }
}