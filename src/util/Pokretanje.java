package util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import enums.Uloga;
import model.KorisnickiNalog;
import model.Korisnik;
import model.KuhinjskiAlat;
import model.Recept;
import model.Sastojak;
import model.podaci.KorisniciLista;
import model.podaci.ReceptiLista;
//import enums.Uloga;
//import model.Cena;
//import model.Cenovnik;
//import model.Jelo;
//import model.KorisnickiNalog;
//import model.Korisnik;
//import model.SlikaJela;
//import model.TipJela;
//import model.podaci.CenovnikLista;
//import model.podaci.JelaLista;
//import model.podaci.KorisniciLista;
//import model.podaci.TipJelaLista;
import serijalizacija.Serijalizacija;

public class Pokretanje {

    public static void inicijalizujKorisnike() throws IOException {
        KorisniciLista korisniciLista = KorisniciLista.getInstance();
        Korisnik admin = new Korisnik(1, "Mirza", "Admirovic", "064324234", LocalDate.parse("1990-07-04"), LocalDate.parse("2008-07-04"),
                new KorisnickiNalog("admin", "admin123", Uloga.ADMINISTRATOR));
        Korisnik mod = new Korisnik(2, "Lav", "Petrovic", "064568634", LocalDate.parse("1990-07-04"), LocalDate.parse("2008-07-04"),
                new KorisnickiNalog("moderator", "moderator123", Uloga.MODERATOR));
        Korisnik kor = new Korisnik(3, "Ana", "Kokic", "064323251", LocalDate.parse("1990-07-04"), LocalDate.parse("2008-07-04"),
                new KorisnickiNalog("user", "user123", Uloga.ULOGOVANKORISNIK));
        korisniciLista.dodajKorisnika(admin);
        korisniciLista.dodajKorisnika(mod);
        korisniciLista.dodajKorisnika(kor);

        Serijalizacija serijalizacija = new Serijalizacija();
        File f = new File("./podaci/korisnici.xml");
        OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
        try {
            serijalizacija.getXStream().toXML(korisniciLista, os);
        } finally {
            os.close();
        }
    }

    public static void inicijalizujRecept() throws IOException {
    	KuhinjskiAlat noz = new KuhinjskiAlat("Nož");
    	LocalDate datum = LocalDate.now();
    	Sastojak so = new Sastojak("So", "Dijamant");
    	Sastojak biber = new Sastojak("Biber", "Dijamant");
    	ArrayList<Sastojak> sastojci = new ArrayList<Sastojak>();
    	sastojci.add(so);
    	sastojci.add(biber);
    	ArrayList<KuhinjskiAlat> alati = new ArrayList<KuhinjskiAlat>();
    	alati.add(noz);
    	ArrayList<model.Slika> slike = new ArrayList<model.Slika>();
		Recept recept = new Recept("Recept neki","Nozem u glavu",datum,sastojci, alati, slike);
		ReceptiLista.getInstance().dodajRecept(recept);
		Serijalizacija serijalizacija = new Serijalizacija();
		File f = new File("./podaci/recepti.xml");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
		try {
			serijalizacija.getXStream().toXML(recept, os);
		} finally {
			os.close();
		}
	}

	
    

}
