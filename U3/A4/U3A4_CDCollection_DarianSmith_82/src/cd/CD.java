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
    
    public String title;//Title of CD
    public String artist;//Artist of CD
    
    public CD(String title, String artist){
        this.title = title;//Set values
        this.artist = artist;
    }
    
    @Override
    public boolean equals(Object other){
        return this.hashCode() == other.hashCode();//So we can create a new CD and see if it's the same as another
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.title);//Hash the title and artist as those are the only imprtant parts
        hash = 61 * hash + Objects.hashCode(this.artist);
        return hash;
    }
    
    @Override
    public String toString(){
        return this.artist + " - " + this.title;//This was only necisary in testing, but it outputs it pretty (Artist - Title)
    }

}
