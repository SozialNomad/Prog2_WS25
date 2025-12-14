package prog2.l19;

import java.io.Serializable;

public class Antwort implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String anzuzeigende;
    private final boolean fertigGeraten;
    private final boolean spielBeendet;
    private final boolean warTreffer;

    public Antwort(String anzuzeigende, boolean fertigGeraten, boolean spielBeendet, boolean warTreffer) {
        this.anzuzeigende = anzuzeigende;
        this.fertigGeraten = fertigGeraten;
        this.spielBeendet = spielBeendet;
        this.warTreffer = warTreffer;
    }

    public String getAnzuzeigende() {
        return anzuzeigende;
    }

    public boolean isFertigGeraten() {
        return fertigGeraten;
    }

    public boolean isSpielBeendet() {
        return spielBeendet;
    }

    public boolean isWarTreffer() {
        return warTreffer;
    }
}
