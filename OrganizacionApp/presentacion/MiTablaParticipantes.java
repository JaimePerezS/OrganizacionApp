package presentacion;
import java.util.*;

import javax.swing.table.*;

class MiTablaParticipantes extends AbstractTableModel {
private String[] nombreColumnas = { Messages.getString("MiTablaParticipantes.0"), Messages.getString("MiTablaParticipantes.1"), Messages.getString("MiTablaParticipantes.2"), "DNI",Messages.getString("MiTablaParticipantes.4"),Messages.getString("MiTablaParticipantes.5"),Messages.getString("MiTablaParticipantes.6"),Messages.getString("MiTablaParticipantes.7"),Messages.getString("MiTablaParticipantes.8"),Messages.getString("MiTablaParticipantes.9")}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
private Vector datos = new Vector();

public int getColumnCount() {return nombreColumnas.length;}

public int getRowCount() {return datos.size();}

public String getColumnName(int col) {return nombreColumnas[col];}

public Object getValueAt(int row, int col) {
Object[] fila = (Object [])datos.elementAt(row);
return fila[col];
}
public Class getColumnClass(int c) {return getValueAt(0, c).getClass();}

public boolean isCellEditable(int row, int col) {return true;}

public void setValueAt(Object value, int row, int col) {
		if (row < getRowCount() && col < getColumnCount()){
 			Object[] fila = (Object [])datos.elementAt(row);
 			fila[col] = value;
 			fireTableCellUpdated(row, col);
 		}
	}

public void eliminaFila (int row){ datos.remove(row);}
    
public void aniadeFila (Object[] row){ datos.add (row);}
}