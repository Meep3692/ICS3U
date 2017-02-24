/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u2a1;

import u2a1.utils.Maths;

/**
 *
 * @author Meep3_000
 */
public class Number2 {
    public static void run(){
        System.out.println("\n\nNumber 2:");
        float width = 5.7f;
        float height = 4.8f;
        float area = Maths.calculateArea(width, height);
        System.out.println("Width: " + Float.toString(width));
        System.out.println("Height: " + Float.toString(height));
        System.out.println("Area: " + Float.toString(area));
    }
}
