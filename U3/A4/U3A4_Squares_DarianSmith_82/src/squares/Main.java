/*
Author: Darian
Date Modified: April 21, 2017
IDE: Netbeans 8.2
Program: Store and list squares of numbers
File: Main entry point, everything else
 */
package squares;

import java.util.ArrayList;

/**
 *
 * @author Meep3_000
 */
public class Main {
    public static void main(String[] args){
        ArrayList squareList = new ArrayList(10);
        for(int i = 0; i < 10; i++){
            squareList.add(i, i*i);
        }
        for(int i = 0; i < squareList.size(); i++){
            System.out.println("Number: " + i + " Square: " + squareList.get(i));
        }
    }
}
