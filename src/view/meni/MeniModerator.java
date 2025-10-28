package view.meni;

public class MeniModerator extends Meni {
	private MeniStavka stavkaSviRecepti;
	private MeniStavka stavkaOdjava;
	public MeniModerator() {
		super();
		stavkaSviRecepti = new MeniStavka("/blender.png", "Svi recepti");
		stavkaOdjava = new MeniStavka("/logout32.png", "Odjava");
		add(stavkaSviRecepti, "wrap, align center");
		add(stavkaOdjava, "wrap, align center");
		
	}
	public MeniStavka getStavkaSviRecepti() {
		return this.stavkaSviRecepti;
	}
	public MeniStavka getStavkaOdjava() {
		return this.stavkaOdjava;
	}
}
