/*
Author: Darian
Date Modified: May 1, 2017
IDE: Netbeans 8.2
Program: Store, display, and modify a cd collection
File: CSV formated table
 */
package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Meep3_000
 */
public class CSVTable {
    
    private final int width;
    
    private final ArrayList<TableEntry> entries;
    
    public CSVTable(int width){
        this.width = width;
        entries = new ArrayList();
    }
    
    public void addEntry(TableEntry entry){
        if(entry.getSize() == width){
            entries.add(entry);
        }
    }
    
    public String getCell(int x, int y){
        return entries.get(y).getCell(x);
    }
    
    public int getLength(){
        return entries.size();
    }
    
    public int getWidth(){
        return width;
    }
    
    public static CSVTable load(String path) throws IOException{
        CSVTable table = null;
        BufferedReader file = new BufferedReader(new FileReader(path));
        String line;
        while((line = file.readLine()) != null){
            String[] lineSegs = line.split(",");
            if(table == null)
                table = new CSVTable(lineSegs.length);
            TableEntry entry = new TableEntry(lineSegs);
            table.addEntry(entry);
        }
        file.close();
        return table;
    }
    
    public void save(String path) throws IOException{
        BufferedWriter file = new BufferedWriter(new FileWriter(path));
        file.write(this.toString());
    }
    
    @Override
    public String toString(){
        String output = "";
        output = entries.stream().map((entry) -> entry.toString() + "\n").reduce(output, String::concat);
        return output;
    }
}
