package prog2.l18.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.GZIPOutputStream;

public class Client {
    public static void main(String[]args) throws IOException {
        byte[] bytesToTransfer = "Hallo Welt\n".getBytes();
        try(Socket connectionToHost = new Socket("127.0.0.1", 5555);
            OutputStream os = connectionToHost.getOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(os)){
            gzip.write(bytesToTransfer);
            gzip.flush();
        }
    }
}
