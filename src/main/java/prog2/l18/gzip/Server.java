package prog2.l18.gzip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.GZIPInputStream;

public class Server {
    public static void main(String[]args) throws IOException{
        try(ServerSocket ss = new ServerSocket(5555);
            Socket conn = ss.accept();
            InputStream is = conn.getInputStream();
            GZIPInputStream gin = new GZIPInputStream(is);
            InputStreamReader isr = new InputStreamReader(gin);
            BufferedReader br =  new BufferedReader(isr)){

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
    }
}
