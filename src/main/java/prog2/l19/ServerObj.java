package prog2.l19;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerObj {
    public static void main(String[]args) throws IOException{
        int PORT = 5555;
        Rateversuch rv = new Rateversuch(5);
        try(ServerSocket ss = new ServerSocket(PORT);
            Socket socket = ss.accept();
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            ){
            oos.flush();
            try(InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is)){
                Antwort antwort = new Antwort("Wort",false, false, false);
                Rateversuch rvVomClient = (Rateversuch) ois.readObject();
                System.out.println("Server: Rateversuch erhalten: " + rvVomClient.num);

                System.out.println("Server: sende Antwort");
                oos.writeObject(antwort);
                oos.flush();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
