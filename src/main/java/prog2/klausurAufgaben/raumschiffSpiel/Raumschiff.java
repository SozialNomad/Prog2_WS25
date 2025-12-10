package prog2.klausurAufgaben.raumschiffSpiel;

public class Raumschiff {
    String kennung;
    int panzerungsstärke;
    Schiffstyp schiffstyp;

    public Raumschiff(String kennung, int panzerungsstärke, Schiffstyp schiffstyp ){
        this.kennung = kennung;
        this.panzerungsstärke = panzerungsstärke;
        this.schiffstyp = schiffstyp;
    }
}
