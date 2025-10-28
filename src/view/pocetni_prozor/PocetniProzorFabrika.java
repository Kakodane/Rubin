package view.pocetni_prozor;


import view.pocetni_prozor.*;

public class PocetniProzorFabrika {

	public PocetniProzorFabrika() {}
	
	public PocetniProzor napraviPocetniProzor(String uloga) {
		switch (uloga) {
		case "Administrator":
			return new PocetniProzorAdministrator();
		case "Moderator":
			return new PocetniProzorModerator();
		case "Ulogovan korisnik":
			return new PocetniProzorUlogovanKorisnik();
		case "Kompanija":
			return new PocetniProzorKompanija();
		default:
			return new PocetniProzor();
		}
	}
	
}
