package view.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kontroler.ReceptiKontroler;
import model.PrijavljenKorisnik;
import model.Recept;
import view.PrijavaProzor;
import view.meni.MeniAdministrator;
import view.meni.MeniFabrika;
import view.meni.MeniUlogovanKorisnik;
import view.panel.PanelDodajRecept;
import view.panel.PanelProfil;
import view.panel.PanelUgovori;
import view.panel.PanelZaposleni;
import view.tabela.recepti.TabelaModelRecepti;
import view.tabela.recepti.TabelaRecepti;

public class PocetniProzorUlogovanKorisnik extends PocetniProzor{
	private MeniUlogovanKorisnik meni;
	private PanelDodajRecept panelDodajRecept;
	private ReceptiKontroler receptiKontroler;
	private TabelaModelRecepti tabelaModelRecepti;
	private List<Recept> recepti;
	public PocetniProzorUlogovanKorisnik() {
	
		this.setName("Administrator prozor");
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniUlogovanKorisnik) meniFabrika.napraviMeni("ULOGOVANKORISNIK");
		this.receptiKontroler= new ReceptiKontroler();
		this.recepti=receptiKontroler.dobaviRececpte();
		this.tabelaModelRecepti=new TabelaModelRecepti(recepti);
		panelDodajRecept = new PanelDodajRecept(receptiKontroler, tabelaModelRecepti);
		paneli = new ArrayList<>(
	            Arrays.asList(new PanelProfil(this), panelDodajRecept
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

meni.getStavkaDodajRecept().getDugmeStavke().addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		postaviPanel("Dodavanje recepta");
		osveziProzor();
	}
});


	}
	
	public PanelDodajRecept getPanelZaposleni() {
		return this.panelDodajRecept;
	}
}

