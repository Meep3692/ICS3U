/*
Author: Darian
Date Modified: March 6, 2017
Program: Prints a bill for a meal including HST
File: Main entry point
 */
package bill;

import java.text.DecimalFormat;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double cost = Math.random() * 13 + 7; //Cost of meal
        double hstRate = 0.13; //Harmonized Sales Tax multiplier
        double hst = cost * hstRate; //HST amount
        double total = cost + hst; //Total cost after HST
        
        DecimalFormat moneyFormat = new DecimalFormat("$##0.00");
        
        System.out.print(
            "      #         ####   ####\n" +
            "     ##        #    # #    #\n" +
            "    # #   #   #      #      #\n" +
            "   #  #  ##  ##      #      #\n" +
            "  ##### # # # #      #      #\n" +
            " #    ##  ##   #    # #    #\n" +
            "#     #   #     ####   ####\n" +
            "***********Eatery************\n\n" + //Splash message
            "Meal:\t\t\t" + moneyFormat.format(cost) + "\n" + //Meal cost
            "HST:\t\t\t" + moneyFormat.format(hst) + "\n" + //HST amount
            "Total:\t\t\t" + moneyFormat.format(total) + "\n"); //Total cost
    }
}
