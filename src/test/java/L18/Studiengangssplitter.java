package L18;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Studiengangssplitter {
    @Test
    public void teste(){
        try(BufferedReader br = new BufferedReader(new FileReader("MatrNr.txt"));

        ) {

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
