package view.pocetni_prozor;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.PrijavljenKorisnik;
import view.panel.PanelProfil;
import view.PrijavaProzor;
import view.panel.PanelZaposleni;
import view.meni.MeniAdministrator;
import view.meni.MeniFabrika;
import view.panel.*;

public class PocetniProzorAdministrator extends PocetniProzor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6275942475923752795L;
	private MeniAdministrator meni;
	private PanelZaposleni panelZaposleni;
	private PanelUgovori panelUgovori;
	public PocetniProzorAdministrator() {
		this.setName("Administrator prozor");
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniAdministrator) meniFabrika.napraviMeni("ADMINISTRATOR");
		panelZaposleni = new PanelZaposleni();
		panelUgovori = new PanelUgovori();
		paneli = new ArrayList<>(
	            Arrays.asList(panelZaposleni, panelUgovori, new PanelProfil(this)
	                          ));
		
		add(paneli.get(0), BorderLayout.CENTER);
		add(meni, BorderLayout.WEST);
		
		
		meni.getStavkaZaposleni().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Zaposleni");
				osveziProzor();
			}
		});
meni.getStavkaOdjava().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijavljenKorisnik.setInstanceToNull();
				zatvori();
				PrijavaProzor prijavaProzor = new PrijavaProzor();
				prijavaProzor.setVisible(true);
			}
		});

meni.getStavkaProfil().getDugmeStavke().addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		postaviPanel("Profil");
		osveziProzor();
	}
});
meni.getStavkaUgovori().getDugmeStavke().addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		postaviPanel("Ugovori");
		osveziProzor();
	}
});

	}
	
	public PanelZaposleni getPanelZaposleni() {
		return this.panelZaposleni;
	}
}
