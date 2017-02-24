/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areaofrectangle;

import awooutils.Maths;

/**
 *
 * @author Meep3_000
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float width = 5.7f;
        float height = 4.8f;
        float area = Maths.calculateArea(width, height);
        System.out.println("Width: " + Float.toString(width));
        System.out.println("Height: " + Float.toString(height));
        System.out.println("Area: " + Float.toString(area));
    }
    
}
