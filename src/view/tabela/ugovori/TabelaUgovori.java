package view.tabela.ugovori;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import util.PogledUtil;
import view.tabela.zaposleni.DugmeBrisanjeZaposlenog;

public class TabelaUgovori extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8781045337604388454L;
	
	public TabelaUgovori(TabelaModelUgovori tabelaModelUgovori) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(tabelaModelUgovori);
		this.getTableHeader().setBackground(PogledUtil.getPrimarnaBoja());
		this.getTableHeader().setForeground(PogledUtil.getForegroundColor());
		this.getTableHeader().setFont(PogledUtil.getTeksPoljeFont());
		this.setFont(PogledUtil.getTeksPoljeFont());
		//new DugmeBrisanjeZaposlenog(this, 6);
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

}
