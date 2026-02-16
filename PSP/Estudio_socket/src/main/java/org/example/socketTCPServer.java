package org.example;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class socketTCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

        public socketTCPServer(int puerto) throws IOException{
            serverSocket = new ServerSocket();
            InetSocketAddress addr = new InetSocketAddress("localhost",puerto);
            // asocia el serverSocket a una address
            serverSocket.bind(addr);
        }

        public void start() throws IOException {
            System.out.println("(Servidor) Esperando conexiones...");
            //Una vez realizada la peticon se crear el objeto socket
            socket = serverSocket.accept();
            // Flujos de entrada y salida de datos, permiten leer bytes
            is = socket.getInputStream();
            os = socket.getOutputStream();
            System.out.println("(Servidor) Conexcion establecida...");
        }

        public void stop() throws IOException {
            System.out.println("(Servidor) Cerrando conexiones...");
            is.close();
            os.close();
            socket.close();
            System.out.println("(Servidor) Conexion cerrada...");
        }

        public static void main(String[] args){
            String solucion = "12345";

            try {
                /* El server socket está asociado a la direccion IP del host, a la misma direccion ip
                de la maquina y a un puerto que se le pasa como parámetro
                 */
                socketTCPServer servidor = new socketTCPServer(12345);
                /*Con start se queda arrancado y escuchando peticioens*/
                servidor.start();
                // Con el .read va leet un integer entre 0 y 255 bytes
                BufferedReader br = new BufferedReader(new InputStreamReader(servidor.is));
                String numeroCliente = br.readLine();

                if (solucion.equals(numeroCliente)){
                    System.out.println("(Servidor) Numero correcto...");
                    servidor.os.write(1);
                } else {
                    System.out.println("(Servidor) Numero erroneo...");
                    servidor.os.write(0);
                }
                // COn el metodo write se manda el mensaje al cleinte
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
