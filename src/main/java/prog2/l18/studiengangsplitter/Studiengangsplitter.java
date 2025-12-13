package prog2.l18.studiengangsplitter;

import java.io.*;

public class Studiengangsplitter {
    public static void splitStudiengaenge(String dateiname){
        System.out.println("WORKDIR = " + new File(".").getAbsolutePath());
        try(BufferedReader br = new BufferedReader(new FileReader(dateiname));
            BufferedWriter bwWInf = new BufferedWriter(new FileWriter("/Users/dodothebird/IdeaProjects/Prog2_WS25/src/main/java/prog2/L18/WInfNr.txt"));
            BufferedWriter bwInf = new BufferedWriter(new FileWriter("/Users/dodothebird/IdeaProjects/Prog2_WS25/src/main/java/prog2/L18/InfNr.txt"));
            BufferedWriter bwEC = new BufferedWriter(new FileWriter("/Users/dodothebird/IdeaProjects/Prog2_WS25/src/main/java/prog2/L18/ECNr.txt"));
        ) {
            do{
                String line = br.readLine();
                if(line == null) break;
                System.out.println("READ: [" + line + "]");
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
                else {
                    throw new MatrikelNummerException("Falsche Matrikelnummer");
                }
            }while(true);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        try{
            splitStudiengaenge("/Users/dodothebird/IdeaProjects/Prog2_WS25/src/main/java/prog2/L18/MatrNr.txt");
        } catch(MatrikelNummerException e){
            System.out.println(e.getMessage());
        }
    }
}

