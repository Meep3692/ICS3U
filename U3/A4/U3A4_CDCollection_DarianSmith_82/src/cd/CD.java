/*
Author: Darian
Date Modified: April 26, 2017
IDE: Netbeans 8.2
Program: Store, display, and modify a cd collection
File: Object to represent a CD
 */
package cd;

import java.util.Objects;

/**
 *
 * @author Meep3_000
 */
public class CD {
    
    public String title;
    public String artist;
    
    public CD(String title, String artist){
        this.title = title;
        this.artist = artist;
    }
    
    @Override
    public boolean equals(Object other){
        return this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.title);
        hash = 61 * hash + Objects.hashCode(this.artist);
        return hash;
    }
    
    @Override
    public String toString(){
        return this.artist + " - " + this.title;
    }

}
