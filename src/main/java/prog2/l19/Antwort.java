package prog2.l19;

import java.io.Serializable;

public class Antwort implements Serializable {
    String anzuzeigende;
    boolean fertigGeraten;
    boolean spielBeendet;
    boolean warTreffer;

    public Antwort(String anzuzeigende, boolean fertigGeraten, boolean spielBeendet, boolean warTreffer){
        this.anzuzeigende = anzuzeigende;
        this.fertigGeraten = fertigGeraten;
        this.spielBeendet = spielBeendet;
        this.warTreffer = warTreffer;
    }
}
