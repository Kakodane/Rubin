package view.dijalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.KuhinjskiAlat;
import model.Recept;
import model.Sastojak;
import model.Slika;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;
import view.FormaDugme;
import view.Labela;

public class DijalogIzmenaRecepta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9035474567150373649L;

	public DijalogIzmenaRecepta(Recept recept) {
		 
        Font  fntNaslov      = PogledUtil.getVelikiNaslovFont();
        Font  fntTekstPolje  = PogledUtil.getTeksPoljeFont();
        Color clrPrimarna    = PogledUtil.getPrimarnaBoja();
        Color clrSekundarna  = PogledUtil.getSekundarnaBoja();
        Color clrForeground  = PogledUtil.getForegroundColor();

        JPanel content = new JPanel(new MigLayout(
            "fillx, insets 20 40 20 40, wrap 1",
            "[grow,fill]"
        ));
        content.setBackground(clrSekundarna);

       
        Labela lblNaslov = new Labela("Izmena recepta", fntNaslov, clrForeground);
        JLabel lblImage  = new JLabel();
        lblImage.setPreferredSize(new Dimension(80, 80));
        lblImage.setIcon(new ImageIcon(getClass().getResource("/recipe.png")));

        JTextArea taSastojci = makeArea(3);
		for (Sastojak s : recept.getSastojci()) {
			taSastojci.append(s.getnaziv() + "\n");
		}
        JTextArea taAlat     = makeArea(3);
        for (KuhinjskiAlat ka : recept.getAlati()) {
        	            taAlat.append(ka.getnaziv() + "\n");
        }
        JTextArea taOpis     = makeArea(3);
        taOpis.setText(recept.getuputstvo());
        JTextArea taPutanja  = makeArea(3);
		for (Slika slika : recept.getSlike()) {
			taPutanja.append(slika.getLink() + "\n");
		}

        JScrollPane spSastojci = wrap(taSastojci);
        JScrollPane spAlat     = wrap(taAlat);
        JScrollPane spOpis     = wrap(taOpis);
        JScrollPane spPutanja  = wrap(taPutanja);

        content.add(lblNaslov, "align center");
        content.add(lblImage,  "align center");

        content.add(new Labela("Sastojci:", fntTekstPolje, clrForeground), "gapy 10");
        content.add(spSastojci, "growx, h 80!");

        content.add(new Labela("Alat:", fntTekstPolje, clrForeground), "gapy 10");
        content.add(spAlat, "growx, h 70!");

        content.add(new Labela("Opis pripreme:", fntTekstPolje, clrForeground), "gapy 10");
        content.add(spOpis, "growx, h 80!");

        content.add(new Labela("Putanja do slike:", fntTekstPolje, clrForeground), "gapy 10");
        content.add(spPutanja, "growx, h 70!");

       

        FormaDugme btnSacuvaj = new FormaDugme("Sačuvaj izmene", clrPrimarna, clrForeground, 125, 20);
        content.add(btnSacuvaj, "align center, w 160!, h 36!, gaptop 10");

        JScrollPane sp = new JScrollPane(content,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        sp.getViewport().setBackground(clrSekundarna);
        sp.setBorder(null);

        setContentPane(sp);

        setMinimumSize(new Dimension(520, 480));
        setPreferredSize(new Dimension(520, 680));
        pack();
    }

    private static JTextArea makeArea(int rows) {
        JTextArea ta = new JTextArea(rows, 40);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        return ta;
    }
    private static JScrollPane wrap(JTextArea ta) {
        JScrollPane sp = new JScrollPane(ta,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setPreferredSize(new Dimension(400, 80));
        return sp;
    }
	
}
