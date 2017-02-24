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
public class Number3 {
    public static void run(){
        System.out.println("\n\nNumber 3:");
        float width = 8.5f;//meters
        float height = 6.0f;//meters
        float priceRate = 19.95f;//dollars/meter^2
        float area = Maths.calculateArea(width, height);
        float totalCost = area * priceRate;
        System.out.println(String.format("The cost of a carpet that is %1.1fm by %2.1fm is $%3.2f", width, height, totalCost));
    }
}
