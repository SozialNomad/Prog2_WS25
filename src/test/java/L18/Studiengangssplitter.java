package L18;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Studiengangssplitter {
    @Test
    public void teste(){
        try(BufferedReader br = new BufferedReader(new FileReader("prog2/L18/MatrNr.txt"));
            BufferedWriter bwWInf = new BufferedWriter(new FileWriter("WInfNr.txt"));
            BufferedWriter bwInf = new BufferedWriter(new FileWriter("InfNr.txt"));
            BufferedWriter bwEC = new BufferedWriter(new FileWriter("ECNr.txt"));
        ) {
            do{
                String line = br.readLine();
                if(line == null) break;
                int num = Integer.parseInt(line);
                if(num >= 5000000 && num <= 5099999){
                    bwWInf.write(line);
                    bwWInf.newLine();
                }
                else if(num >= 5100000 && num <= 5199999){
                    bwInf.write(line);
                    bwInf.newLine();
                }
                else if(num >= 6100000 && num <= 6199999){
                    bwEC.write(line);
                    bwEC.newLine();
                }
            }while(true);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
