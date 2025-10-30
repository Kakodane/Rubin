package model.podaci;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import enums.Uloga;
import model.Korisnik;

@XStreamAlias("korisniciLista")
public class KorisniciLista {

    public static KorisniciLista instance = null;

    @XStreamAlias("korisnici")
    private ArrayList<Korisnik> korisnici;

    private KorisniciLista() {
        this.korisnici = new ArrayList<Korisnik>();
    }

    public static KorisniciLista getInstance() {
        if (instance == null) {
            instance = new KorisniciLista();
        }

        return instance;
    }

    public long generisiId() {
        int brojKorisnika = korisnici.size();
        return ++brojKorisnika;
    }

    public static void setInstance(KorisniciLista korisniciLista) {
        instance = korisniciLista;
    }

    public ArrayList<Korisnik> getKorisnici() {
        return this.korisnici;
    }

    public void setKorisnici(ArrayList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik dodajKorisnika(Korisnik korisnik) {
        this.korisnici.add(korisnik);
        return korisnik;
    }

    public void izmeniKorisnika(String ime,String prezime,String telefon,int id) {
        Korisnik korisnik = dobaviKorisnikaPoKorisnickomId(id);
        korisnik.setIme(ime);
        korisnik.setPrezime(prezime);
        korisnik.setTelefon(telefon);

        for (int i = 0; i < korisnici.size(); i++) {
            if (korisnici.get(i).getId() == korisnik.getId()) {
                korisnici.remove(i);
                korisnici.add(i, korisnik);
            }
        }
    }

    public Korisnik dobaviKorisnikaPoKorisnickomImenu(String korisnickoIme) {
        ArrayList<Korisnik> korisnikLista = (ArrayList<Korisnik>) korisnici
                .stream()
                .filter(korisnik -> korisnik.getKorisnickiNalog().getKorisnickoIme().equals(korisnickoIme))
                .collect(Collectors.toList());
        if (korisnikLista.size() == 0) {
            return null;
        }

        return korisnikLista.get(0);
    }

    public Korisnik dobaviKorisnikaPoKorisnickomId(int id){
        return korisnici.stream().filter(u-> u.getId()==id).findFirst().orElse(null);
    }
    
    public void obrisiKorisnika(String korisnickoIme) {
    	Korisnik korisnik = this.dobaviKorisnikaPoKorisnickomImenu(korisnickoIme);
    	korisnici.remove(korisnik);
    }
    
    public ArrayList<Korisnik> filtrirajKorisnike(Uloga uloga){
    	ArrayList<Korisnik> filtriraniKorisnici = new ArrayList<Korisnik>();
    	for(Korisnik korisnik : korisnici) {
    		if(korisnik.getKorisnickiNalog().getUloga().equals(uloga)) {
    			filtriraniKorisnici.add(korisnik);
    		}
    	}
    	return filtriraniKorisnici;
    }
}