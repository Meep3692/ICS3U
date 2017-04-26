/*
Author: Darian
Date Modified: April 24, 2017
IDE: Netbeans 8.2
Program: Store, display, and modify a cd collection
File: Table model to display cds
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
        super(new String[]{"Artist", "Title"}, 0);
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
            super.addRow(new String[]{cd.artist, cd.title});
        });
    }
}
