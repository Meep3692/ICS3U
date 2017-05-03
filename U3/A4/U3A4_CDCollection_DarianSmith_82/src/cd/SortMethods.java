/*
Author: Darian
Date Modified: April 26, 2017
IDE: Netbeans 8.2
Program: Store, display, and modify a cd collection
File: Enumerator of sorting methods
 */
package cd;

/**
 *
 * @author Meep3_000
 */
public enum SortMethods {
    NONE,//Just use the array
    ARTIST,//Use the CDArtistComparator
    TITLE//Use the CDTitleComparator
}
