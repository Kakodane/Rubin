package view.tabela.recepti;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import kontroler.ReceptiKontroler;
import model.Recept;
import view.dijalog.DialogIzmenaProfila;
import view.dijalog.DijalogIzmenaRecepta;

public class DugmeIzmenaRecepti  extends AbstractCellEditor
implements TableCellRenderer, TableCellEditor, MouseListener {

	private JTable tabela;
	private JButton prikazDugme;
	private JButton akcijaDugme;
	private boolean isEditorActive = false;
	private int currentViewRow = -1;
	
	public DugmeIzmenaRecepti(JTable tabela, int kolona) {

		this.tabela = tabela;
		this.tabela.getColumnModel().getColumn(kolona).setCellRenderer(this);
		this.tabela.getColumnModel().getColumn(kolona).setCellEditor(this);
		this.tabela.addMouseListener(this);
		
		this.prikazDugme = new JButton("Izmeni");
		this.akcijaDugme = new JButton("Izmeni");
		
		
		this.akcijaDugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				 int viewRow = (tabela.getEditingRow() >= 0) ? tabela.getEditingRow() : currentViewRow;
		            if (viewRow < 0) return;
		            
		            int modelRow = tabela.convertRowIndexToModel(viewRow);
		            TabelaModelRecepti model = (TabelaModelRecepti) tabela.getModel();
		            Recept recept = model.getAt(modelRow);
		            ReceptiKontroler kontroler=new ReceptiKontroler();
				DijalogIzmenaRecepta dialog = new DijalogIzmenaRecepta(recept,kontroler,model);
				dialog.setVisible(true);
			}
		});
		
		this.isEditorActive = false;
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (tabela.isEditing() && tabela.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (isEditorActive && tabela.isEditing()) {
			tabela.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	    currentViewRow = row; // ← BITNO: zapamti view red koji je otvorio editor
	    akcijaDugme.setText(value == null ? "Izmeni" : value.toString());
	    return akcijaDugme;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return prikazDugme;
	}
}
