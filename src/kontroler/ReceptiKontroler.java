package kontroler;

import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import model.KuhinjskiAlat;
import model.Recept;
import model.Sastojak;
import model.Slika;
import model.podaci.ReceptiLista;
import util.Validacija;

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
	
	public Recept dodajRecept(String naziv,String uputstvo,LocalDate datumDodavanja, ArrayList<Sastojak> sastojci, ArrayList<KuhinjskiAlat> alati, ArrayList<Slika>slike) throws
	MissingValueException, BadFormatException {
		if (Validacija.praznaIliNepostojecaVrednost(naziv)) {
			throw new MissingValueException("Nije unet naziv recepta.");
		} else if (Validacija.praznaIliNepostojecaVrednost(uputstvo)) {
			throw new MissingValueException("Nije unet pustupak pripreme.");
		} 
		
		ReceptiLista receptiLista=ReceptiLista.getInstance();
		long receptId=receptiLista.generisiId();
		
		Recept recept= new Recept(naziv,uputstvo,datumDodavanja, sastojci, alati, slike);
		receptiLista.dodajRecept(recept);
		
		return recept;
	}
	
	public List<Recept> dobaviRececpte(){
		List<Recept> lista= ReceptiLista.getInstance().dobaviRecepte();
		return lista;
	}
	
	public boolean obrisiRecept(Recept recept) {
	    return model.podaci.ReceptiLista.getInstance().obrisiRecept(recept);
	}

}
