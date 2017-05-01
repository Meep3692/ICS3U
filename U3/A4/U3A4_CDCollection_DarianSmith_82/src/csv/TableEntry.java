/*
Author: Darian
Date Modified: May 1, 2017
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
    private String[] contents;
    
    public TableEntry(String[] contents){
        this.contents = contents;
    }
    
    public TableEntry(){
        this.contents = new String[0];
    }
    
    public String getCell(int position){
        if(position < contents.length && position >= 0){
            return contents[position];
        }
        return "";
    }
    
    public int getSize(){
        return contents.length;
    }
    
    @Override
    public String toString(){
        String output = "";
        for(String cell : contents){
            output += cell + ",";
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }

}
