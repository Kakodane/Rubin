package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("recept")
public class Recept {
    private String nazivRecepta;
    private String uputstvo;
    private LocalDate datumKreiranja;
    private ArrayList<Sastojak> sastojci;
    private ArrayList<KuhinjskiAlat> alati;
    private ArrayList<Slika> slike;

  

    public Recept(String nazivRecepta, String uputstvo, LocalDate datumKreiranja,
            ArrayList<Sastojak> sastojci, ArrayList<KuhinjskiAlat> alati, ArrayList<Slika> slike) {
        super();
        this.nazivRecepta = nazivRecepta;
        this.uputstvo = uputstvo;
        this.datumKreiranja = datumKreiranja;
        this.sastojci = sastojci;
        this.alati = alati;
        this.slike = slike;
    }

    public String getNazivRecepta() {
        return nazivRecepta;
    }

    public void setNazivRecepta(String nazivRecepta) {
        this.nazivRecepta = nazivRecepta;
    }

    public String getuputstvo() {
        return uputstvo;
    }

    public void setuputstvo(String uputstvo) {
        this.uputstvo = uputstvo;
    }

    public LocalDate getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(LocalDate datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public List<Sastojak> getSastojci() {
        return sastojci;
    }

    public void setSastojci(ArrayList<Sastojak> sastojci) {
        this.sastojci = sastojci;
    }

    public List<KuhinjskiAlat> getAlati() {
        return alati;
    }

    public void setAlati(ArrayList<KuhinjskiAlat> alati) {
        this.alati = alati;
    }

    public List<Slika> getSlike() {
        return slike;
    }

    public void setSlike(ArrayList<Slika> slike) {
        this.slike = slike;
    }

	public void azurirajRecept(String nazivRecepta, String uputstvo, LocalDate datumKreiranja, ArrayList<Sastojak> sastojci,
			ArrayList<KuhinjskiAlat> alati, ArrayList<Slika> slike) {
		this.nazivRecepta = nazivRecepta;
		this.uputstvo = uputstvo;
		this.datumKreiranja = datumKreiranja;
		this.sastojci = sastojci;
		this.alati = alati;
		this.slike = slike;
	}

}