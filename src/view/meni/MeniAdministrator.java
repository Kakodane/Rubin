package view.meni;

import view.meni.MeniStavka;

public class MeniAdministrator extends Meni {
	private MeniStavka stavkaZaposleni;
	private MeniStavka stavkaOdjava;
	private MeniStavka stavkaUgovori;
	public MeniAdministrator() {
		super();
		stavkaZaposleni = new MeniStavka("/employees1.png", "Korisnici");
		stavkaOdjava = new MeniStavka("/logout32.png", "Odjava");
		stavkaUgovori= new MeniStavka("/contract.png", "Ugovori");
		add(stavkaZaposleni, "wrap, align center");
		add(stavkaUgovori, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
		
	}
	public MeniStavka getStavkaZaposleni() {
		return this.stavkaZaposleni;
	}
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
	
	public MeniStavka getStavkaUgovori() {
		return this.stavkaUgovori;
	}

}
