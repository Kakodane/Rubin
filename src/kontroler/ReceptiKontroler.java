package kontroler;

import java.time.LocalDate;
import java.util.ArrayList;

import model.KuhinjskiAlat;
import model.Recept;
import model.Sastojak;
import model.Slika;

public class ReceptiKontroler {
	
	private Recept recept;
	
	public ReceptiKontroler() {}
	
	public Recept dobaviReceptPoNazivu(String naziv) {
		Recept recept = model.podaci.ReceptiLista.getInstance().dobaviReceptPoNazivu(naziv);
		if (recept == null) {
			return null;
		}

		return recept;
	}

	public void izmeniRecept(String naziv, String uputstvo, ArrayList<KuhinjskiAlat> alati, ArrayList<Sastojak> sastojci, ArrayList<Slika> slike, LocalDate datum) {
		model.podaci.ReceptiLista.getInstance().izmeniRecept(naziv, uputstvo, alati, sastojci, slike, datum);
	}

}
