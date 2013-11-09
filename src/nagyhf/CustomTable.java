package nagyhf;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;


import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.*;

public class CustomTable extends JPanel{
	JTable jtable;
	JScrollPane scrollPane;
	
	public CustomTable(ArrayList cin,String[] head) {
        super(new GridBagLayout());
        
        jtable = new JTable(new CustomTableModel(cin,head));
        
       
        scrollPane = new JScrollPane(jtable);
        jtable.setPreferredScrollableViewportSize(new Dimension(500, 170));
        jtable.setFillsViewportHeight(true);
        
        add(scrollPane);
    }
	
	
	public class CustomTableModel extends AbstractTableModel{
		private String[] columns;
		private ArrayList<Car> carsList;
		
		public CustomTableModel(ArrayList ina,String[] headers){
			carsList = ina;
			columns = headers;
		}
		@Override
		public int getColumnCount() {
			return columns.length;
		}
	
		@Override
		public int getRowCount() {
			return carsList.size();
		}
	
		@Override
		public Object getValueAt(int row, int col) {
			
			switch(col) {
	        case 0: {
	        	return carsList.get(row).getZero();
	        }
	        case 1: {
	        	return carsList.get(row).getOne();
	        }
	        case 2: {
	        	 return carsList.get(row).getTwo();
	        	
	        }
	        case 3: {
	        	return carsList.get(row).getThree();
	        }
	        default: return null;
	        }
			
		}
		
		public boolean isCellEditable(int row,int col){
			return true;
		}
		
		public void setValueAt(Object value, int row, int col) {
			
			switch(col) {
	        case 0: {
	        	carsList.get(row).setZero((Integer)value);
	        	fireTableCellUpdated(row,col);
	        	break;
	        }
	        case 1: {
	        	carsList.get(row).setOne((String)value);
	        	System.out.println(" tesztkiir setnel "+carsList.get(row).getOne());
	        	fireTableCellUpdated(row,col);
	        	break;
	        }
	        case 2: {
	        	carsList.get(row).setTwo((String)value);
	        	fireTableCellUpdated(row,col);
	        	break;
	        }
	        case 3: {
	        	carsList.get(row).setThree((Integer)value);
	        	fireTableCellUpdated(row,col);
	        	break;
	        }
	        }
			
	        
	        
	    }
		
		public String getColumnName(int col) {
	        return columns[col];
	    }
		
		public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }
	}
}