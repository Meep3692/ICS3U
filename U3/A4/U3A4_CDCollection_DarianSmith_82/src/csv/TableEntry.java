/*
Author: Darian
Date Modified: May 2, 2017
IDE: Netbeans 8.2
Program: Store, display, and modify a cd collection
File: Entry in a table
 */
package csv;

/**
 *
 * @author Meep3_000
 */
public class TableEntry{
    private String[] contents;//String array to hold cells
    
    public TableEntry(String[] contents){
        this.contents = contents;//Set contents to given string array
    }
    
    public TableEntry(){
        this.contents = new String[0];//New, empty entry
    }
    
    public String getCell(int position){
        if(position < contents.length && position >= 0){//Make sure we're inside the range
            return contents[position];//Return value of cell
        }
        return "";//Outside range, nothing there
    }
    
    public int getSize(){
        return contents.length;
    }
    
    @Override
    public String toString(){
        String output = "";
        for(String cell : contents){
            String safeCell = cell.replace(",", "\\,");
            output += safeCell + ",";
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }

}
