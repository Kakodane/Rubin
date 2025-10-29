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

public class DugmeBrisanjeRecepti extends AbstractCellEditor
implements TableCellRenderer, TableCellEditor, MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4511248940209800297L;
	private JTable tabela;
	private JButton prikazDugme;
	private JButton akcijaDugme;
	private ReceptiKontroler receptiKontroler;
	private boolean isEditorActive = false;
	
	public DugmeBrisanjeRecepti(JTable tabela, int kolona) {

		this.tabela = tabela;
		this.tabela.getColumnModel().getColumn(kolona).setCellRenderer(this);
		this.tabela.getColumnModel().getColumn(kolona).setCellEditor(this);
		this.tabela.addMouseListener(this);
		this.receptiKontroler=new ReceptiKontroler();
		this.prikazDugme = new JButton("Obriši");
		this.akcijaDugme = new JButton("Obriši");
		
		this.akcijaDugme.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        int selectedRow = tabela.getSelectedRow();
		        if (selectedRow == -1) return;
		        int confirm = JOptionPane.showConfirmDialog(
		            tabela,
		            "Da li ste sigurni da želite da obrišete recept?",
		            "Potvrda brisanja",
		            JOptionPane.YES_NO_OPTION
		        );
		        if (confirm != JOptionPane.YES_OPTION) return;

		        TabelaModelRecepti model = (TabelaModelRecepti) tabela.getModel();
		        Recept receptZaBrisanje = model.getAt(selectedRow);

		        boolean uspesno = receptiKontroler.obrisiRecept(receptZaBrisanje);

		        if (uspesno) {
		            model.removeRecept(selectedRow);
		            JOptionPane.showMessageDialog(
		                tabela,
		                "Recept je uspešno obrisan.",
		                "Brisanje recepta",
		                JOptionPane.INFORMATION_MESSAGE
		            );
		        } else {
		            JOptionPane.showMessageDialog(
		                tabela,
		                "Došlo je do greške pri brisanju recepta.",
		                "Greška",
		                JOptionPane.ERROR_MESSAGE
		            );
		        }

		       
		        fireEditingStopped();
		    }
		});
		
		this.isEditorActive = false;
	}
	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (tabela.isEditing() && tabela.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (isEditorActive && tabela.isEditing()) {
			tabela.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
			int row, int column) {
		return akcijaDugme;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		return prikazDugme;
	}
	
	
}
