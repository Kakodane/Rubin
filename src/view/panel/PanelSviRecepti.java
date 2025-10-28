package view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kontroler.ReceptiKontroler;
import model.Recept;
import net.miginfocom.swing.MigLayout;
import observer.Observer;
import util.PogledUtil;
import view.FormaDugme;
import view.Labela;
import view.TekstPolje;
import view.tabela.recepti.TabelaModelRecepti;
import view.tabela.recepti.TabelaRecepti;
import view.tabela.zaposleni.TabelaModelZaposleni;
import view.tabela.zaposleni.TabelaZaposleni;

public class PanelSviRecepti extends JPanel implements observer.Observer {
	private ArrayList<Recept> recepti;
	private ReceptiKontroler receptKontroler;
	private TabelaRecepti tabelaRecepti;
	public PanelSviRecepti() {
		setName("Svi recepti");
		setVisible(true);
		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
		receptKontroler = new ReceptiKontroler();
		this.recepti = model.podaci.ReceptiLista.getInstance().getRecepti();
		
		Labela lblNaslov = new Labela("Pregled i CRUD recepti", fntNaslov, clrForeground);

        JLabel lblImage = new JLabel();
        lblImage.setPreferredSize(new Dimension(80, 80));
        lblImage.setIcon(new ImageIcon(getClass().getResource("/cook-book.png")));

        TekstPolje txtAreaRecepti = new TekstPolje("", fntTekstPolje, 240, 30);
        FormaDugme btnPretrazi    = new FormaDugme("Pretraži", clrPrimarna, clrForeground, 95, 28);

        // ===== MIG LAYOUT =====
        setLayout(new MigLayout(
            "fill, insets 20 30 20 30",
            "[grow,fill]",
            "[]8[]15[]10[grow]"   // naslov, slika, pretraga, tabela
        ));

        // Naslov + slika gore
        add(lblNaslov, "align center, wrap");
        add(lblImage,  "align center, wrap");

        // Red za pretragu (polje + dugme)
        add(txtAreaRecepti, "split 2, growx");          // polje zauzima širinu
        add(btnPretrazi,    "w 110!, h 32!, wrap");     // normalno dugme

        // Tabela ispod – rasteže se
        JScrollPane scrollPane = inicijalizujTabeluRecepata();
        add(scrollPane, "grow, push, span, wrap");
		
	}
	
	private void azurirajPrikaz() {
		TabelaModelRecepti model = (TabelaModelRecepti) tabelaRecepti.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	  private JScrollPane inicijalizujTabeluRecepata() {
	        TabelaModelRecepti model = new TabelaModelRecepti(this.recepti);
	        model.addObserver(this);
	        this.tabelaRecepti = new TabelaRecepti(model);
	        JScrollPane scrollPane = new JScrollPane(tabelaRecepti);
	        scrollPane.setPreferredSize(new Dimension(800, 500)); // može i bez ovoga
	        return scrollPane;
	    }



	@Override
	public void updatePerformed(EventObject e) {
		// TODO Auto-generated method stub
		
	}
}
