package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private String mensajeRecibido = "";
    private String mensajeAEnviar = "";

    public static void main(String[] args) {new Cliente().iniciar();}
    private void iniciar() {
        try (Socket socket = new Socket("localhost", 7287);) {
            System.out.println("Conexión establecida con el servidor");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (!mensajeRecibido.equals("salir")) {
                mensajeAEnviar = new Scanner(System.in).nextLine();
                dos.writeUTF(mensajeAEnviar);
                mensajeRecibido = dis.readUTF();
                System.out.println("servidor: " + mensajeRecibido);
            }
            System.out.println("Cerrando conexión...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




