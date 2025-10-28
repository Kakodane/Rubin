package view.panel;

import java.util.EventObject;

import javax.swing.JPanel;

import observer.Observer;

public class PanelDodajRecept extends JPanel implements Observer{
	public PanelDodajRecept() {
		setName("Dodaj recept");
	}

	@Override
	public void updatePerformed(EventObject e) {
		// TODO Auto-generated method stub
		
	}
}
