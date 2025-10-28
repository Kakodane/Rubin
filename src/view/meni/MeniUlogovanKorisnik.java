package view.meni;

public class MeniUlogovanKorisnik extends Meni{
	private MeniStavka stavkaDodajRecept;
	private MeniStavka stavkaOdjava;
	public MeniUlogovanKorisnik() {
		super();
		stavkaDodajRecept = new MeniStavka("/add.png", "Dodaj recept");
		stavkaOdjava = new MeniStavka("/logout32.png", "Odjava");
		add(stavkaDodajRecept, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
		
	}
	public MeniStavka getStavkaDodajRecept() {
		return this.stavkaDodajRecept;
	}
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
	


}
