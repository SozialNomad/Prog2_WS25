package prog2.l19;

import java.io.*;
import java.net.Socket;
import java.io.Serializable;

public class ClientObj{
    public static void main(String[]args) throws IOException, ClassNotFoundException {
        Rateversuch rv = new Rateversuch(5);
        try(Socket socket = new Socket("localhost", 5555);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
        ){
            oos.flush();
            try(InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is)){
                // ZUERST senden
                oos.writeObject(rv);
                oos.flush();
                System.out.println("Client: Rateversuch gesendet");
                // DANN Antwort lesen
                Antwort a = (Antwort) ois.readObject();
                System.out.println(a.anzuzeigende);
            }
        }
    }
}
