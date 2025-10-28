package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("sastojak")
public class Sastojak {

    private String naziv;
    private String proizvodjac;

    public Sastojak() {}

    public Sastojak(String naziv, String proizvodjac) {
        super();
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
    }

    public String getnaziv() {
        return naziv;
    }
    public void setnaziv(String naziv) {
        this.naziv = naziv;
    }
    public String getproizvodjac() {
        return proizvodjac;
    }
    public void setproizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }
}