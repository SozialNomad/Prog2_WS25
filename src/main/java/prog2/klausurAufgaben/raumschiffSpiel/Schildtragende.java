package prog2.klausurAufgaben.raumschiffSpiel;

import java.util.ArrayList;
import java.util.List;

public class Schildtragende extends Raumschiff{
    int schildenergie;
    public Schildtragende(String kennung, int panzerungsstärke, Schiffstyp schiffstyp, int schildenergie){
        super(kennung, panzerungsstärke, schiffstyp);
        this.schildenergie = schildenergie;
    }

    public List<Integer> schildEnergieAbrunden(List<Schildtragende> liste){
        List<Integer> schildEnergien = new ArrayList<>();
        for(Schildtragende s: liste){
            schildEnergien.add(s.getSchildenergie() / 2);
        }
        return schildEnergien;
    }
    public int getSchildenergie(){
        return schildenergie;
    }
}
