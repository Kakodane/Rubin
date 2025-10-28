package view.meni;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.FormaDugme;

public class MeniStavka extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7627665089080505037L;
	private JLabel lblIkonica;
	private FormaDugme btnStavka;
	
	public MeniStavka() {}
	
	public MeniStavka(String ikonica, String naziv) {
		
		setPreferredSize(new Dimension(250, 30));
		setBackground(new Color(102, 0, 102));
		
		lblIkonica = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource(ikonica)).getImage();
		lblIkonica.setIcon(new ImageIcon(image));
		btnStavka = new FormaDugme(naziv, new Color(0, 102, 255), Color.WHITE, 170, 30);
		
		add(lblIkonica);
		add(btnStavka);
		
	}
	
	public JButton getDugmeStavke() {
		return this.btnStavka;
	}
	
}
