package view.tabela.recepti;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.Korisnik;
import model.Recept;
import model.Sastojak;
import observer.IzmenaTabeleEvent;
import observer.Observer;
import observer.Publisher;

public class TabelaModelRecepti extends AbstractTableModel implements Publisher{
	private List<Recept> recepti;
	private List<Observer> observers;
	
	public TabelaModelRecepti(List<Recept> recepti) {
		this.recepti = recepti;
	}

	public void dodajSastojak(Recept recept) {
		this.recepti.add(recept);
	}
	
	public void izmeniSastojak(Recept izmenjenRecept) {
		for (int i = 0; i < recepti.size(); i++) {
			if (recepti.get(i).getNazivRecepta().equals(izmenjenRecept.getNazivRecepta())) {
				recepti.remove(i);
				recepti.add(i, izmenjenRecept);
			}
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return recepti.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Naziv recepta";
			case 1:
				return "Uputstvo";
				case 2:
					return "datum kreiranja";
				case 3:
					return "sastojci";
					
				case 4:
					return "alati";
					case 5:
						return "slike";
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
		case 3:
		case 4:
			case 5:
			return String.class;
		case 6:
		case 7:
			return JButton.class;
		default:
			return null;
		}
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Recept recept = recepti.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return recept.getNazivRecepta();
			case 1:
				return recept.getuputstvo();
			case 2:
				return recept.getDatumKreiranja().toString();
			case 3:
				String sastojciString = "";
				for (Sastojak s : recept.getSastojci()) {
					sastojciString += s.getnaziv() + ", ";
				}
				if (sastojciString.length() > 2) {
					sastojciString = sastojciString.substring(0, sastojciString.length() - 2);
				}
				return sastojciString;
			case 4:
				String alatiString = "";
				for (int i = 0; i < recept.getAlati().size(); i++) {
					alatiString += recept.getAlati().get(i).getnaziv();
					if (i < recept.getAlati().size() - 1) {
						alatiString += ", ";
					}
				}
				return alatiString;
			case 5:
				String slikeString = "";
				for (int i = 0; i < recept.getSlike().size(); i++) {
					slikeString += recept.getSlike().get(i).getLink();
					if (i < recept.getSlike().size() - 1) {
						slikeString += ", ";
					}
				}
				return slikeString;
			default:
				return "";
			
		}
	}

	@Override
	public void addObserver(Observer observer) {
		if (observers == null)
			observers = new ArrayList<Observer>();
		observers.add(observer);	
	}

	@Override
	public void removeObserver(Observer observer) {
		if (null == observers)
			return;
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.updatePerformed(new IzmenaTabeleEvent());
		}
	}
	@Override
	public boolean isCellEditable(int row, int col) {
	    return col == 6 || col == 7; 
	}
	public Recept getAt(int modelRow) {
	    return recepti.get(modelRow);
	}
	

}
