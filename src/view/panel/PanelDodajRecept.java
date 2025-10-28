package view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import observer.Observer;
import util.PogledUtil;
import view.FormaDugme;
import view.Labela;
import view.TekstPolje;

public class PanelDodajRecept extends JPanel implements Observer{
	public PanelDodajRecept() {
		setName("Dodavanje recepta");
		setVisible(true);
		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
		Labela lblNaslov = new Labela("Dodavanje recepta", fntNaslov, clrForeground);
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/recipe.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		
		
		Labela lblSastojci = new Labela("Sastojci:", fntTekstPolje, clrForeground);
		JTextArea taSastojci = new JTextArea(6, 40); // redovi, kolone (samo hint)
		taSastojci.setLineWrap(true);
		taSastojci.setWrapStyleWord(true);
		taSastojci.setRows(3);
		JScrollPane spSastojci = new JScrollPane(taSastojci);

		Labela lblAlat = new Labela("Alat:", fntTekstPolje, clrForeground);
		JTextArea taAlat = new JTextArea(4, 40);
		taAlat.setLineWrap(true);
		taAlat.setWrapStyleWord(true);
		taAlat.setRows(3);
		JScrollPane spAlat = new JScrollPane(taAlat);

		Labela lblOpis = new Labela("Opis pripreme:", fntTekstPolje, clrForeground);
		JTextArea taOpis = new JTextArea(8, 40);
		taOpis.setLineWrap(true);
		taOpis.setWrapStyleWord(true);
		taOpis.setRows(3);
		JScrollPane spOpis = new JScrollPane(taOpis);
		
		Labela lblPutanjaDoSlike = new Labela("Putanja do slike:", fntTekstPolje, clrForeground);
		JTextArea taPutanjaDoSlike= new JTextArea(4, 40);
		taPutanjaDoSlike.setLineWrap(true);
		taPutanjaDoSlike.setWrapStyleWord(true);
		taPutanjaDoSlike.setRows(3);
		JScrollPane spPutanjaDoSlike = new JScrollPane(taPutanjaDoSlike);
		
		
		FormaDugme btnDodaj = new FormaDugme("Dodaj recept", clrPrimarna, clrForeground,125,20);
		
		setLayout(new MigLayout(
			    "fillx, insets 20 40 20 40, wrap 1",
			    "[grow,fill]"
			));

			// naslov i slika
			add(lblNaslov, "align center");
			add(lblImage,  "align center");

			// polja (labela pa textarea u scrollu)
			add(lblSastojci,       "gapy 10");
			add(spSastojci,        "growx, h 80!, w 100%");

			add(lblAlat,           "gapy 10");
			add(spAlat,            "growx, h 70!,  w 100%");

			add(lblOpis,           "gapy 10");
			add(spOpis,            "growx, h 80!, w 100%");

			add(lblPutanjaDoSlike, "gapy 10");
			add(spPutanjaDoSlike,  "growx, h 70!,  w 100%");

		

			// dugme normalne širine
			add(btnDodaj,          "align center, w 160!, h 36!, gaptop 10");
	}

	@Override
	public void updatePerformed(EventObject e) {
		// TODO Auto-generated method stub
		
	}
}
