package prog2.l18.galgenmännchen;

import java.io.*;
import java.net.Socket;

public class ClientGal {
    public static void main(String[]args) throws IOException {
        try(Socket socket = new Socket("localhost", 5555);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osr = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osr);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            InputStream isConsole = System.in;
            InputStreamReader isrConsole = new InputStreamReader(isConsole);
            BufferedReader consoleBr = new BufferedReader(isrConsole);

        ){
            String line;
            while((line = consoleBr.readLine())!= null){
                bw.write(line);
                bw.newLine();
                bw.flush();

                // Antwort lesen (Server sendet "OK" als Zeile)
                String ok = br.readLine();
                if (ok == null) {
                    System.out.println("Server hat Verbindung geschlossen.");
                    break;
                }
                System.out.println("Server: " + ok);
            }

        }

    }
}
