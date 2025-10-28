package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("kuhinjskiAlat")
public class KuhinjskiAlat {
    private String naziv;

    public KuhinjskiAlat() {}
    public KuhinjskiAlat(String naziv) {
        super();
        this.naziv = naziv;
    }
    public String getnaziv() {
        return naziv;
    }
    public void setnaziv(String naziv) {
        this.naziv = naziv;
    }

}