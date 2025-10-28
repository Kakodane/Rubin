package view.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.PrijavljenKorisnik;
import view.PrijavaProzor;
import view.meni.MeniFabrika;
import view.meni.MeniModerator;
import view.meni.MeniUlogovanKorisnik;
import view.panel.PanelDodajRecept;
import view.panel.PanelProfil;
import view.panel.PanelSviRecepti;

public class PocetniProzorModerator extends PocetniProzor{
	private MeniModerator meni;
	private PanelSviRecepti panelSviRecepti;
	public PocetniProzorModerator() {
	
		this.setName("Administrator prozor");
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniModerator) meniFabrika.napraviMeni("MODERATOR");
		panelSviRecepti = new PanelSviRecepti();
		paneli = new ArrayList<>(
	            Arrays.asList(new PanelProfil(this), panelSviRecepti
	                          ));
		
		add(paneli.get(0), BorderLayout.CENTER);
		add(meni, BorderLayout.WEST);
	
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

meni.getStavkaSviRecepti().getDugmeStavke().addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		postaviPanel("Svi recepti");
		osveziProzor();
	}
});


	}
	
	public PanelSviRecepti getPanelZaposleni() {
		return this.panelSviRecepti;
	}
}
