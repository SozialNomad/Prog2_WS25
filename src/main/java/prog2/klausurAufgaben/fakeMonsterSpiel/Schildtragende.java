package prog2.klausurAufgaben.fakeMonsterSpiel;

import java.util.List;

public class Schildtragende extends Raumschiff{
    int schildenergie;
    public Schildtragende(String kennung, int panzerungsstärke, Schiffstyp schiffstyp, int schildenergie){
        super(kennung, panzerungsstärke, schiffstyp);
        this.schildenergie = schildenergie;
    }

    public List<Schildtragende> schildEnergieAbrunden(List<Schildtragende> liste){
        for(Schildtragende s: liste){
            int i = s.schildenergie / 2;
        }
        return liste;
    }
}
