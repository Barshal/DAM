package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class socketTCPCliente {
    private String serverIP;
    private int serverPort;
    private static Socket socket;
    private InputStream is;
    private OutputStream os;

    public socketTCPCliente(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws UnknownHostException, IOException{
        System.out.println("(Cliente) Estableciendo conexion...");
        socket = new Socket();
        InetSocketAddress addrs = new InetSocketAddress("localhost",12345);
        socket.connect(addrs);
        os = socket.getOutputStream();
        is = socket.getInputStream();
        System.out.println("(Cliente) Conexion establecida...");
    }

    public void stop() throws IOException{
        System.out.println("(Cliente) Cerrando conexion...");
        is.close();
        os.close();
        socket.close();
    }

    public static void main(String[] args){
        // Socket con la direccion y el puerto del servidor
        socketTCPCliente cliente = new socketTCPCliente("localhost",12345);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el numero (12345 es el correcto)-> ");
        String numeroCliente = scanner.next();

        int respuestaServidor;

        try {
            cliente.start();

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(numeroCliente);

            respuestaServidor = cliente.is.read();

            if (respuestaServidor == 1){
                System.out.println("Numero correcto");
            } else {
                System.out.println("Numero incorrecto");
            }

            cliente.stop();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
