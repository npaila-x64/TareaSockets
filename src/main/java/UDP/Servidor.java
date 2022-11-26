package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {

    private final byte[] buffer = new byte[256];

    public static void main(String[] args) {
        try {
            new Servidor().iniciar();
        } catch (SocketException ignored) {}
    }

    private void iniciar() throws SocketException {
        DatagramSocket ds = new DatagramSocket(7286);

        while (true) {
            try {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                System.out.println("Esperando mensaje...");
                ds.receive(dp);
                String message = new String(dp.getData(), 0, dp.getLength());
                System.out.printf("Mensaje recibido: %s\n", message);
            } catch (IOException e) {
                System.err.printf("Hubo un error en la conexión. %s\n", e.getMessage());
                break;
            }
        }
    }
}




