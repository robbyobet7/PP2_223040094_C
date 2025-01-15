package MembershipORM.src.view.jenismember;

import MembershipORM.src.model.JenisMember;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class JenisMemberTableModel extends AbstractTableModel {
    
    private String[] columnNames = {"Nama"};
    private List<JenisMember> data;

    public JenisMemberTableModel(List<JenisMember> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }
    
    public int getRowCount() {
        return data.size();
    }
    
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Object getValueAt(int row, int col) {
        JenisMember rowItem = data.get(row);
        String value="";
        
        switch(col){
            case 0:
                value = rowItem.getNama();
                break;
        }
        
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(JenisMember value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void setData(List<JenisMember> data) {
        this.data = data;
        fireTableDataChanged();
    }
    
}