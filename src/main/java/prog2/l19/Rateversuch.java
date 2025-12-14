package prog2.l19;

import java.io.Serializable;

public class Rateversuch implements Serializable {
    private static final long serialVersionUID = 1L;

    private final char buchstabe;

    public Rateversuch(char buchstabe) {
        this.buchstabe = buchstabe;
    }

    public char getBuchstabe() {
        return buchstabe;
    }

}

