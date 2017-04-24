/*
Author: 
Date Modified: 
IDE: Netbeans 8.2
Program: 
File: 
 */
package cd;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Meep3_000
 */
public class CDTableModel extends DefaultTableModel {
    public CDTableModel(){
        super(new String[]{"Title", "Artist"}, 0);
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
    
    public void setCDs(ArrayList<CD> cds){
        while(super.getRowCount() > 0){
            super.removeRow(0);
        }
        cds.forEach((cd) -> {
            super.addRow(new String[]{cd.title, cd.artist});
        });
    }
}
