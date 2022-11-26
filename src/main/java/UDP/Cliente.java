package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            new Cliente().iniciar();
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private void iniciar() throws SocketException, UnknownHostException {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("localhost");

        while (true) {
            try {
                System.out.print("> ");
                String message = new Scanner(System.in).nextLine();
                byte[] buffer = message.getBytes();
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, 7286);
                ds.send(dp);
                System.out.println("Un mensaje fue enviado.");
            } catch (IOException e) {
                System.err.printf("Hubo un error en el envío del mensaje. %s\n", e.getMessage());
                break;
            }
        }
    }
}



