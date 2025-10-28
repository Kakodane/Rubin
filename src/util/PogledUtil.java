package util;

import java.awt.Color;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

public class PogledUtil {
	
	public static Font getRobotoFont(int velicina, boolean isBold) {
		if (isBold) {
			return new Font("roboto", Font.BOLD, velicina);
		} else {
			return new Font("roboto", Font.PLAIN, velicina);
		}
		
	}
	
	public static Font getLabelaFont() {
		return getRobotoFont(16, true);
	}
	
	public static Font getTeksPoljeFont() {
		return getRobotoFont(14, false);
	}
	
	public static Font getMaliNaslovFont() {
		return getRobotoFont(18, true);
	}
	
	public static Font getVelikiNaslovFont() {
		return getRobotoFont(24, true);
	}
	
	// zelena
	public static Color getPrimarnaBoja() {
		return new Color(255, 51, 153);
	}
	
	// siva
	public static Color getSekundarnaBoja() {
		return new Color(204, 51, 255);
	}
	
	// svetlo siva
	public static Color getTercijarnaBoja() {
		return new Color(255, 255, 0);
	}
	
	public static Color getForegroundColor() {
		return Color.WHITE;
	}
	
	public static DateTimeFormatter getFormatDatuma() {
		return DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	}
	
	public static String[] getTipoviKorisnikaAdminRegistracija() {
		String[] tipoviZaposlenih = { "Administrator", "Moderator", "Ulogovan korisnik"};
		return tipoviZaposlenih;
	}
	public static String[] getTipoviKorisnika() {
		String[] tipoviZaposlenih = { "Administrator", "Moderator", "Ulogovan korisnik","Kompanija"};
		return tipoviZaposlenih;
	}
}
