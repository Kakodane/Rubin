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
import model.podaci.KorisniciLista;
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

    public static void inicijalizujJela() throws IOException {
//        JelaLista jelaLista = JelaLista.getInstance();
//        TipJelaLista tipJelaLista = TipJelaLista.getInstance();
//        CenovnikLista cenovnikLista = CenovnikLista.getInstance();
//
//        TipJela tipJela1 = new TipJela(1, "Rostilj");
//        TipJela tipJela2 = new TipJela(2, "Paste");
//        TipJela tipJela3 = new TipJela(3, "Supe i čorbe");
//
//        Jelo jelo1 = new Jelo(1, "Ćevapi", "Odlični ćevapi","adadsad", false, tipJela1, new SlikaJela("/cevapi.jpg"));
//        Jelo jelo2 = new Jelo(2, "Kobasica", "Prava domaca","dfgdfg", false, tipJela1, new SlikaJela("/rostiljKobasica.jpg"));
//        Jelo jelo3 = new Jelo(3, "Mesano meso", "Svega po malo, 1kg","cvbcvb", false, tipJela1, new SlikaJela("/mesanoMeso.jpg"));
//
//        Cena cena1 = new Cena(350, 0, LocalDate.parse("2020-07-04"));
//        Cena cena2 = new Cena(280, 0, LocalDate.parse("2021-05-10"));
//        Cena cena3 = new Cena(1100, 0, LocalDate.parse("2018-03-12"));
//        Cena cena4 = new Cena(1100, 0, LocalDate.parse("2019-03-12"));
//
//        Cenovnik cenovnik1 = new Cenovnik(1, new ArrayList<Cena>(Arrays.asList(cena1, cena2)));
//        Cenovnik cenovnik2 = new Cenovnik(2, new ArrayList<Cena>(Arrays.asList(cena2, cena3)));
//        Cenovnik cenovnik3 = new Cenovnik(3, new ArrayList<Cena>(Arrays.asList(cena3, cena4)));
//
//        tipJelaLista.dodajTipJela(tipJela1);
//        tipJelaLista.dodajTipJela(tipJela2);
//        tipJelaLista.dodajTipJela(tipJela3);
//
//        jelaLista.dodajJelo(jelo1);
//        jelaLista.dodajJelo(jelo2);
//        jelaLista.dodajJelo(jelo3);
//
//        cenovnikLista.dodajCenovnik(cenovnik1);
//        cenovnikLista.dodajCenovnik(cenovnik2);
//        cenovnikLista.dodajCenovnik(cenovnik3);
//
//        Serijalizacija serijalizacija = new Serijalizacija();
//        File fajlTipoviJela = new File("./podaci/tipoviJela.xml");
//        File fajlJela = new File("./podaci/jela.xml");
//        File fajlCenovnik = new File("./podaci/cenovnik.xml");
//        OutputStream osTipoviJela = new BufferedOutputStream(new FileOutputStream(fajlTipoviJela));
//        OutputStream osJela = new BufferedOutputStream(new FileOutputStream(fajlJela));
//        OutputStream osCenovnik = new BufferedOutputStream(new FileOutputStream(fajlCenovnik));
//
//        try {
//            serijalizacija.getXStream().toXML(tipJelaLista, osTipoviJela);
//            serijalizacija.getXStream().toXML(jelaLista, osJela);
//            serijalizacija.getXStream().toXML(cenovnikLista, osCenovnik);
//        } finally {
//            osTipoviJela.close();
//            osJela.close();
//            osCenovnik.close();
//        }
    }

}
