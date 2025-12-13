package prog2.l18.galgenmännchen;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGal {
    public static void main(String[]args) throws IOException{
        try(ServerSocket ss = new ServerSocket(5555);
            Socket socket = ss.accept();
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osr = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osr);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr)){
            String line;
            while((line = br.readLine())!= null){
                bw.write("OK");
                bw.newLine();
                bw.flush();
            }

        }
    }
}
