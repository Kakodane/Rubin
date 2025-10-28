package view.tabela.ugovori;

import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.KorisnickiNalog;
import model.Korisnik;
import observer.Observer;
import util.PogledUtil;

public class TabelaModelUgovori extends AbstractTableModel implements observer.Publisher {

	private List<KorisnickiNalog> kompanije;
	private List<Observer> observers;
	
	public TabelaModelUgovori(List<KorisnickiNalog> kompanije) {
		this.kompanije = kompanije;
	}

	private void dodajKorisnickiNalog(KorisnickiNalog kn) {
        this.kompanije.add(kn);
    }
	public void izmeniKorisnika(KorisnickiNalog izmenjenKorisnik) {
		// TODO Auto-generated method stub
	}
	
	
	
	
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Korisnicko ime";
		case 1:
			return "Lozinka";
		case 2:
			return "Uloga";

		default:
			return "";
		}
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
			return String.class;
		case 3:
			return JButton.class;
		default:
			return null;
		}
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		KorisnickiNalog korisnik = kompanije.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return korisnik.getKorisnickoIme();
		case 1:
			return korisnik.getLozinka();
		case 2:
			return korisnik.getUloga();	
		case 3:
			return new JButton();
		default:
			return "";
		}
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 3;
	}
	

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}
