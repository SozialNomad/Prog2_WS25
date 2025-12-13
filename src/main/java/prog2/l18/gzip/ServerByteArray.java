package prog2.l18.gzip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.GZIPInputStream;

public class ServerByteArray {
    public static void main(String[]args) throws IOException {
        try(ServerSocket ss = new ServerSocket(5555);
            Socket conn = ss.accept();
            GZIPInputStream gin = new GZIPInputStream(conn.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream()){

            byte[] buf = new byte[1024];
            int n;
            while((n = gin.read(buf)) != -1){
                baos.write(buf, 0, n);
            }
            String text = baos.toString();
            System.out.println(text);
        }
    }
}
