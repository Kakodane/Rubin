package view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import izuzeci.ResultEmptyException;
import kontroler.KorisnikKontroler;
import model.Korisnik;
import model.PrijavljenKorisnik;
import net.miginfocom.swing.MigLayout;
import observer.IzmenaKorisnikaEvent;
import observer.Observer;
import view.FormaDugme;
import view.Labela;
import view.dijalog.DialogIzmenaProfila;
import view.pocetni_prozor.PocetniProzor;
import util.PogledUtil;

public class PanelProfil extends JPanel implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2302967480314898683L;
	private PrijavljenKorisnik prijavljenKorisnik = PrijavljenKorisnik.getInstance();
	private Korisnik korisnik;
	private KorisnikKontroler korisnikKontroler;
	
	private Labela lblImeVr;
	private Labela lblPrezimeVr;
	private Labela lblTelefonVr;
	
	public PanelProfil(PocetniProzor pocetniProzor) {
		setName("Profil");
		setVisible(true);
		
		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntLabela = PogledUtil.getLabelaFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
		korisnikKontroler = new KorisnikKontroler();
		try {
			korisnik = korisnikKontroler.dobaviKorisnikaPoKorImenu(prijavljenKorisnik.getKorisnickoIme());	
		} catch (ResultEmptyException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);
		}
		korisnikKontroler.setKorisnik(korisnik);
		korisnik.addObserver(this);
//		if (pocetniProzor.getName().equals("VlasnikPocetniProzor")) {
//			korisnik.addObserver((((PocetniProzorVlasnik)pocetniProzor).getPanelZaposleni()));
//		}
		
		Labela lblNaslov = new Labela("Pregled i izmena profilnih podataka", fntNaslov, clrForeground);
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/profile96.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		Labela lblIme = new Labela("Ime:", fntLabela, clrTercijarna);
		lblImeVr = new Labela(korisnik.getIme(), fntLabela, clrForeground);
		
		Labela lblPrezime = new Labela("Prezime:", fntLabela, clrTercijarna);
		lblPrezimeVr = new Labela(korisnik.getPrezime(), fntLabela, clrForeground);
		
		Labela lblKorIme = new Labela("Korisnicko ime:", fntLabela, clrTercijarna);
		Labela lblKorImeVr = new Labela(korisnik.getKorisnickiNalog().getKorisnickoIme(), fntLabela, clrForeground);
		
		Labela lblUloga = new Labela("Uloga:", fntLabela, clrTercijarna);
		Labela lblUlogaVr = new Labela(korisnik.getKorisnickiNalog().getUloga().toString(), fntLabela, clrForeground);
		
		Labela lblTelefon = new Labela("Telefon:", fntLabela, clrTercijarna);
		lblTelefonVr = new Labela(korisnik.getTelefon(), fntLabela, clrForeground);
		
		
		Labela lblDatumZap = new Labela("Datum zaposlenja:", fntLabela, clrTercijarna);
		Labela lblDatumZapVr = new Labela(PogledUtil.getFormatDatuma().format(korisnik.getDatumZaposlenja()), fntLabela, clrForeground);
		
		Labela lblDatumRodj = new Labela("Datum rodjenja:", fntLabela, clrTercijarna);
		Labela lblDatumRodjVr = new Labela(PogledUtil.getFormatDatuma().format(korisnik.getDatumRodjenja()), fntLabela, clrForeground);
	
		FormaDugme btnIzmena = new FormaDugme("Izmena", clrPrimarna, clrForeground, 150, 20);
		btnIzmena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogIzmenaProfila dialogIzmenaProfila = new DialogIzmenaProfila(korisnik, korisnikKontroler);
				dialogIzmenaProfila.setVisible(true);
			}
		});
		
		FormaDugme btnIzmenaLozinke = new FormaDugme("Promena lozinke", clrPrimarna, clrForeground, 150, 20);
	
		setLayout(new MigLayout(
			    "insets 20",                        // margine oko panela
			    "[right]10[200!]40[right]10[200!]", // 4 kolone: L,V, L,V
			    "[]10[]20[]10[]10[]10[]20[]"        // redovi i vertikalni razmaci
			));

			// naslov i slika
			add(lblNaslov,        "span 4, align center, wrap");
			add(lblImage,         "span 4, align center, wrap");

			// red 1
			add(lblIme);
			add(lblImeVr,         "growx");
			add(lblPrezime);
			add(lblPrezimeVr,     "growx, wrap");

			// red 2
			add(lblKorIme);
			add(lblKorImeVr,      "growx");
			add(lblUloga);
			add(lblUlogaVr,       "growx, wrap");

			// red 3
			add(lblTelefon);
			add(lblTelefonVr,     "growx");
			add(lblDatumZap);
			add(lblDatumZapVr,    "growx, wrap");

			// red 4 (samo levi blok; vrednost rasteže preko desnog bloka)
			add(lblDatumRodj);
			add(lblDatumRodjVr,   "growx, span 3, wrap");

			// dugmad (isti red: levo/centar i desno)
			add(btnIzmena,        "span 2, align center");
			add(btnIzmenaLozinke, "span 2, align right, wrap");
	}

	@Override
	public void updatePerformed(EventObject e) {
		IzmenaKorisnikaEvent izmenaKorisnikaEvent = (IzmenaKorisnikaEvent) e;
		lblImeVr.setText(izmenaKorisnikaEvent.getKorisnik().getIme());
		lblPrezimeVr.setText(izmenaKorisnikaEvent.getKorisnik().getPrezime());
		lblTelefonVr.setText(izmenaKorisnikaEvent.getKorisnik().getTelefon());
		this.repaint();
	}
}
