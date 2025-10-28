package view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.KorisnickiNalog;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;
import view.FormaDugme;
import view.Labela;
import view.PadajucaLista;
import view.TekstPolje;
import view.dijalog.DijalogRegistrovanjeZaposlenog;
import view.tabela.ugovori.TabelaModelUgovori;
import view.tabela.ugovori.TabelaUgovori;
import view.tabela.zaposleni.TabelaModelZaposleni;
import view.tabela.zaposleni.TabelaZaposleni;

public class PanelUgovori extends JPanel {

    private static final long serialVersionUID = 1L;
    private TabelaUgovori tabela;

    public PanelUgovori() {
        setName("Ugovori");
        setVisible(true);

        Font fntNaslov = PogledUtil.getVelikiNaslovFont();
        Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
        Color clrPrimarna = PogledUtil.getPrimarnaBoja();
        Color clrSekundarna = PogledUtil.getSekundarnaBoja();
        Color clrForeground = PogledUtil.getForegroundColor();

        setBackground(clrSekundarna);

        Labela lblNaslov = new Labela("Kompanije sa kojima je potpisan ugovor", fntNaslov, clrForeground);

        JLabel lblImage = new JLabel("");
        lblImage.setPreferredSize(new Dimension(80, 80));
        lblImage.setIcon(new ImageIcon(this.getClass().getResource("/enterprise.png")));

        // Layout – samo naslov, ikonica i tabela
        Labela lblTipZaposlenog = new Labela("Naziv kompanije:", fntTekstPolje, clrForeground);
		TekstPolje txtTipZaposlenog = new TekstPolje("search", fntTekstPolje, 100, 30);
		
		FormaDugme btnDodajKompaniju = new FormaDugme("Dodaj kompaniju", clrPrimarna, clrForeground, 150, 20);
		
		
		FormaDugme btnPretrazi = new FormaDugme("Pretraži", clrPrimarna, clrForeground, 75, 20);
		
		setLayout(new MigLayout("", "80[]40[]", "90[]30[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		add(lblImage, "wrap, span2, align center");
		add(lblTipZaposlenog, "cell 0 2, align left");
		add(txtTipZaposlenog, "cell 0 2, align left");
		add(btnPretrazi, "cell 0 2, gapleft 10, align left");
		add(btnDodajKompaniju, "cell 1 2, wrap, align right");
        inicijalizujTabelu();
    }

    private void inicijalizujTabelu() {
        // Prazan model sa 4 kolone: Korisničko ime, Lozinka, Uloga, Dugme
    	List<KorisnickiNalog> lista = null; // ovde ide lista korisnickih naloga sa ugovorima
        TabelaModelUgovori model = new TabelaModelUgovori(lista);
        this.tabela = new TabelaUgovori(model); // koristi tvoj custom JTable
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setPreferredSize(new Dimension(800, 500));
        add(scroll, "align center, wrap");
    }

    /** Minimalni prazan model sa 4 kolone bez redova */
    private static class PrazanNalogModel extends AbstractTableModel {
        private static final long serialVersionUID = 1L;

        private static final String[] COLS = {
            "Korisničko ime", "Lozinka", "Uloga", "Dugme"
        };

        @Override public int getRowCount() { return 0; }              // nema podataka
        @Override public int getColumnCount() { return COLS.length; }
        @Override public String getColumnName(int c) { return COLS[c]; }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0: // korisničko ime
                case 1: // lozinka
                case 2: // uloga
                    return String.class;
                case 3: // dugme kolona
                    return JButton.class;
                default:
                    return Object.class;
            }
        }

        @Override public boolean isCellEditable(int r, int c) { return false; }
        @Override public Object getValueAt(int r, int c) { return null; } // prazno
    }
}
