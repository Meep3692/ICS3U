/*
Author: Darian
Date Modified: May 2, 2017
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
    
    private final int width;//Width of the table
    
    private final ArrayList<TableEntry> entries;//Arraylist to store entries
    
    public CSVTable(int width){
        this.width = width;//Set table width
        entries = new ArrayList();//Initialise entries list
    }
    
    public void addEntry(TableEntry entry){
        if(width == entry.getSize()){//Make sure the entry is the right size
            entries.add(entry);//Add entry to list
        }
    }
    
    public String getCell(int x, int y){
        if(y >= 0 && y < entries.size())//Make sure we're in the table
            return entries.get(y).getCell(x);//Return the cell in that x pos from the entry at that y pos
        return "";//Outside the table, nothing here
    }
    
    public int getLength(){
        return entries.size();//Safely return the length
    }
    
    public int getWidth(){
        return width;//Safely return the width
    }
    
    public static CSVTable load(String path) throws IOException{
        CSVTable table = null;//Initialise the table
        BufferedReader file = new BufferedReader(new FileReader(path));//Open the file
        String line;//String to hold line in
        while((line = file.readLine()) != null){//While there is still a line to read, read it into line
            ArrayList<String> lineList = new ArrayList();//List to hold segments of the current entry
            String currentEntry = "";//String to store current cell
            //Unescape to safely saved commas
            for(int i = 0; i < line.length(); i++){//Itterate through characters
                if(line.charAt(i) == ','){//If it's a comma seperating segments
                    lineList.add(currentEntry);//Add cell to the list
                    currentEntry = "";//Reset for the next cell
                }
                else if(line.charAt(i) == '\\' && line.charAt(i + 1) == ','){//An escaped comma
                    currentEntry += ",";//Add a literal comma to the cell
                    i++;
                }else{
                    currentEntry += line.charAt(i);//Just add the character to the cell
                }
            }
            lineList.add(currentEntry);//Add final entry (it has no comma)
            String[] lineSegs = new String[lineList.size()];//String[] to store cells (needed for entry)
            for(int i = 0; i < lineList.size(); i++){//Move objects from list into array
                lineSegs[i] = lineList.get(i);//Cast everything 1 by 1 because we cant cast Object[] to String[]
            }
            if(table == null)//If we haven't defined the table yet (first line)
                table = new CSVTable(lineSegs.length);//We have to do this here so we know the width
            TableEntry entry = new TableEntry(lineSegs);//Declare a new entry based to the array made earlier
            table.addEntry(entry);//Add entry to the table
        }
        file.close();//Close the file. No sense in leaving resources open
        return table;//Return the table
    }
    
    public void save(String path) throws IOException{
        BufferedWriter file = new BufferedWriter(new FileWriter(path));//Open the file
        file.write(this.toString());//Write this table into it
        file.flush();//Push it all into the file
        file.close();//Close the stream
    }
    
    @Override
    public String toString(){
        String output = "";//Initialise temp output string
        output = entries.stream().map((entry) -> entry.toString() + "\n").reduce(output, String::concat);//Iterate throught entries adding each to the output
        return output;//Return the output
    }
}
