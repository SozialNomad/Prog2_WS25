package prog2.l19;

import java.io.*;
import java.net.Socket;
import java.io.Serializable;
import java.util.Scanner;

public class ClientObj{
    public static void main(String[]args) throws IOException, ClassNotFoundException {
        try (Socket socket = new Socket("localhost", 5555);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            oos.flush(); // wichtig: Header senden

            try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                 Scanner sc = new Scanner(System.in)) {

                // Erstes Objekt vom Server lesen (Initial-Anzeige)
                Antwort a;
                try {
                    a = (Antwort) ois.readObject();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Aktuell: " + a.getAnzuzeigende());

                while (!a.isSpielBeendet() && !a.isFertigGeraten()) {
                    System.out.print("Rate einen Buchstaben: ");
                    String input = sc.nextLine();

                    if (input == null || input.isBlank()) {
                        System.out.println("Bitte 1 Buchstaben eingeben.");
                        continue;
                    }

                    char guess = input.trim().charAt(0);

                    // Immer NEUES Objekt senden
                    Rateversuch rv = new Rateversuch(guess);
                    oos.writeObject(rv);
                    oos.flush();

                    try {
                        a = (Antwort) ois.readObject();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Treffer? " + a.isWarTreffer());
                    System.out.println("Aktuell: " + a.getAnzuzeigende());
                }

                if (a.isFertigGeraten()) {
                    System.out.println("✅ Wort fertig geraten!");
                } else if (a.isSpielBeendet()) {
                    System.out.println("❌ Spiel beendet!");
                }
            }
        }
    }
}
