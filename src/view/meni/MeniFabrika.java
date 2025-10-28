package view.meni;

import view.*;

public class MeniFabrika {

	public MeniFabrika() {}
	
	public Meni napraviMeni(String uloga) {
		switch (uloga) {
		case "ADMINISTRATOR":
			return new MeniAdministrator();
		case "MODERATOR":
			return new MeniModerator();
		case "ULOGOVANKORISNIK":
			return new MeniUlogovanKorisnik();
		default:
			return new Meni();
		}
	}
	
}
