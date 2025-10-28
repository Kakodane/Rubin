package izuzeci;

import java.io.Serial;

public class MissingValueException extends Exception {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 5312025210245566381L;
    private String naslov;

    public MissingValueException(String poruka) {
        super(poruka);
        naslov  = "Nedostajuća vrednost";
    }

    public String getNaslov() {
        return this.naslov;
    }
}
