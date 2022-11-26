package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    private String mensajeRecibido = "";
    private String mensajeAEnviar = "";
    public static void main(String[] args) {new Servidor().iniciar();}
    private void iniciar() {
        try {
            ServerSocket ss = new ServerSocket(7287);
            System.out.println("Esperando cliente...");
            Socket cliente = ss.accept();
            System.out.println("Conexión establecida con el cliente");
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            while (!mensajeRecibido.equals("salir")) {
                mensajeRecibido = dis.readUTF();
                System.out.println("cliente: " + mensajeRecibido);
                mensajeAEnviar = new Scanner(System.in).nextLine();
                dos.writeUTF(mensajeAEnviar);
                dos.flush();
            }
            System.out.println("Cerrando conexión...");
            cliente.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


