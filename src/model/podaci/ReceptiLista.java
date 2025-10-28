package model.podaci;

import java.time.LocalDate;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import model.KuhinjskiAlat;
import model.Recept;
import model.Sastojak;
import model.Slika;

@XStreamAlias("receptiLista")
public class ReceptiLista {
    public static ReceptiLista instance = null;

    @XStreamAlias("recepti")
    private ArrayList<Recept> recepti;

    private ReceptiLista() {
        this.recepti=new ArrayList<Recept>();
    }

    public static ReceptiLista getInstance() {
        if (instance==null) {
            instance=new ReceptiLista();
        }
        return instance;
    }

    public long generisiId() {
        int brojRecepta= recepti.size();
        return ++brojRecepta;
    }

    public static void setInstance(ReceptiLista receptiLista) {
        instance = receptiLista;
    }

    public ArrayList<Recept> getRecepti(){
        return this.recepti;
    }

    public void setRecepti(ArrayList<Recept> recepti) {
        this.recepti=recepti;
    }

    public Recept dodajRecept(Recept recept) {
        this.recepti.add(recept);
        return recept;
    }
    
	public void izmeniRecept(String naziv, String uputstvo, ArrayList<KuhinjskiAlat> alati, ArrayList<Sastojak> sastojci, ArrayList<Slika> slike, LocalDate datum) {
		        Recept r = dobaviReceptPoNazivu(naziv);
        if (r != null) {
            r.setNazivRecepta(naziv);
            r.setuputstvo(uputstvo);
            r.setAlati(alati);
            r.setSastojci(sastojci);
            r.setSlike(slike);
            r.setDatumKreiranja(datum);
        }
	}
	
	public Recept dobaviReceptPoNazivu(String naziv) {
		for (Recept r : recepti) {
			if (r.getNazivRecepta().equalsIgnoreCase(naziv)) {
				return r;
			}
		}
		return null;
	}
	
}