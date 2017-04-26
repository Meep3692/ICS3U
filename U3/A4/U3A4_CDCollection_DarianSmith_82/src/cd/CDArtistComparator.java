/*
Author: Darian
Date Modified: April 26, 2017
IDE: Netbeans 8.2
Program:  Store, display, and modify a cd collection
File: Comparator for CDs based on artist
 */
package cd;

import java.util.Comparator;

/**
 *
 * @author Meep3_000
 */
public class CDArtistComparator implements Comparator<CD> {

    @Override
    public int compare(CD o1, CD o2) {
        return o1.artist.compareTo(o2.artist);
    }
    
}
