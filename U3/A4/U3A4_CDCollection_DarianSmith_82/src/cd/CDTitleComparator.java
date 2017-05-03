/*
Author: Darian
Date Modified: April 26, 2017
IDE: Netbeans 8.2
Program:  Store, display, and modify a cd collection
File: Comparator for CDs based on title
 */
package cd;

import java.util.Comparator;

/**
 *
 * @author Meep3_000
 */
public class CDTitleComparator implements Comparator<CD> {

    @Override
    public int compare(CD o1, CD o2) {
        return o1.title.compareTo(o2.title);//Compare the titles. Used for sorting
    }
    
}
