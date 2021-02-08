package gui;

import java.util.Vector;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class ModeleTable extends AbstractTableModel implements TableModelListener{
    private Object[][] data;
    private String[] titles;
     
    public ModeleTable(Object[][] donnees, String[] titres){
        data = donnees;
        titles = titres;
        this.addTableModelListener(this);
    }
    public int getColumnCount() {
        return titles.length;
    }
    public String getColumnName(int numColonne){
        return titles[numColonne];
    }
    public int getRowCount() {
        if(data == null) return 0;
        else return data[0].length;
    }
    public Object getValueAt(int numLigne, int numColonne) {
        return data[numLigne][numColonne];
    }
    public boolean isCellEditable(int numLigne, int numColonne){
        if(numColonne == 1) return true;
        else return false;
    }
         
    public void tableChanged(TableModelEvent arg0) {
        this.fireTableDataChanged();
         
    }
     
 
}