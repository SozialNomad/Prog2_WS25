package L18;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HangmanTest {
    @Test
    public void testeTCPServer(){
        final int PORT = 5000;
        try(ServerSocket ss = new ServerSocket(PORT);
            Socket conn = ss.accept();
            //OutputStream os = new OutputStream();
        ){

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
