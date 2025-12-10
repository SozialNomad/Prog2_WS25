package klausurAufgaben.raumschiffTest;

import org.junit.jupiter.api.Test;
import prog2.klausurAufgaben.raumschiffSpiel.Schiffstyp;
import prog2.klausurAufgaben.raumschiffSpiel.Schildtragende;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaumschiffTest {
    @Test
    public void testeObSchildEnergieKorrektRauskommt(){
        Schildtragende s1 = new Schildtragende("10004", 4, Schiffstyp.Jäger, 78);
        Schildtragende s2 = new Schildtragende("23402", 7, Schiffstyp.Kreuzer, 56);
        Schildtragende s3 = new Schildtragende("30002", 7, Schiffstyp.Kreuzer, 56);
        Schildtragende s4 = new Schildtragende("13001", 2, Schiffstyp.Fregatte, 132);
        List<Schildtragende> liste = List.of(s1,s2,s3,s4);
        int s1se = s1.getSchildenergie() / 2;
        int s2se = s2.getSchildenergie() / 2;
        int s3se = s3.getSchildenergie() / 2;
        int s4se = s4.getSchildenergie() / 2;
        List<Integer> schildEnergienHalbiert = List.of(s1se,s2se,s3se,s4se);
        //List<Integer> result = liste.schildEnergieAbrunden(liste); //methodu burada nasil cagiriyiruz, alternatif olarak assertEqualsin icinde kullanilabilir miydi
        assertEquals(schildEnergienHalbiert, s1.schildEnergieAbrunden(liste));
        //önemli nokta: s1.schildEnergieAbrunden yaptiginda listeyi cagiriyor

    }
}
