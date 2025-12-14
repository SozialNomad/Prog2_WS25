package prog2.l19;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ServerObj {
    public static void main(String[]args) throws IOException{
        int PORT = 5555;

        // --- Mini-Spielzustand (einfach, aber korrekt) ---
        final String wort = "WORT";          // demo; später zufällig wählen
        final int maxFehler = 7;             // demo
        int fehler = 0;
        Set<Character> geraten = new HashSet<>();

        try (ServerSocket ss = new ServerSocket(PORT);
             Socket socket = ss.accept();
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            oos.flush(); // wichtig: Header senden

            try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                // Initiale Anzeige schicken (optional, aber nett)
                Antwort antwort = baueAntwort(wort, geraten, false, false);
                oos.writeObject(antwort);
                oos.flush();

                while (!antwort.isSpielBeendet() && !antwort.isFertigGeraten()) {
                    Rateversuch rv;

                    try {
                        rv = (Rateversuch) ois.readObject();
                    } catch (EOFException eof) {
                        System.out.println("Client hat Verbindung geschlossen.");
                        break;
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    char guess = Character.toUpperCase(rv.getBuchstabe());
                    boolean warTreffer;

                    if (!Character.isLetter(guess)) {
                        // Nicht-Buchstabe zählt hier als Fehler (kannst du ändern)
                        fehler++;
                        warTreffer = false;
                    } else if (geraten.contains(guess)) {
                        // Wiederholung: kein extra Fehler (kannst du ändern)
                        warTreffer = wort.indexOf(guess) >= 0;
                    } else {
                        geraten.add(guess);
                        warTreffer = wort.indexOf(guess) >= 0;
                        if (!warTreffer) fehler++;
                    }

                    boolean fertig = istFertig(wort, geraten);
                    boolean beendet = fehler >= maxFehler;

                    // Wichtig: jedes Mal ein NEUES Antwort-Objekt senden
                    antwort = baueAntwort(wort, geraten, fertig, beendet, warTreffer);

                    oos.writeObject(antwort);
                    oos.flush();
                }

                System.out.println("Server: Spiel beendet.");
            }
        }
    }

    private static Antwort baueAntwort(String wort, Set<Character> geraten,
                                       boolean fertigGeraten, boolean spielBeendet) {
        return baueAntwort(wort, geraten, fertigGeraten, spielBeendet, false);
    }

    private static Antwort baueAntwort(String wort, Set<Character> geraten,
                                       boolean fertigGeraten, boolean spielBeendet, boolean warTreffer) {
        String anzeigen = maskiere(wort, geraten);
        return new Antwort(anzeigen, fertigGeraten, spielBeendet, warTreffer);
    }

    private static String maskiere(String wort, Set<Character> geraten) {
        StringBuilder sb = new StringBuilder();
        for (char c : wort.toCharArray()) {
            if (geraten.contains(c)) sb.append(c);
            else sb.append('_');
        }
        return sb.toString();
    }

    private static boolean istFertig(String wort, Set<Character> geraten) {
        for (char c : wort.toCharArray()) {
            if (!geraten.contains(c)) return false;
        }
        return true;
    }
}
