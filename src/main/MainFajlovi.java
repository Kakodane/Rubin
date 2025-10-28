package main;

import java.io.IOException;

import izuzeci.ResultEmptyException;
import view.PrijavaProzor;
import serijalizacija.Serijalizacija;
import util.Pokretanje;

public class MainFajlovi {

    public static void main(String[] args) throws IOException, ResultEmptyException {
        //Pokretanje.inicijalizujKorisnike();
    	//Pokretanje.inicijalizujRecept();
        Serijalizacija serijalizacija = new Serijalizacija();
        //serijalizacija.sacuvaj();
        serijalizacija.ucitaj();
        PrijavaProzor prijavaProzor = new PrijavaProzor();
        prijavaProzor.setVisible(true);
    }

}
