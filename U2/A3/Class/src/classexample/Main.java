/*
 * This program demonstrates the use of the Math class
 */

package classexample;

public class Main {

    public static void main(String[] args) {

        // Declare Variables
        double myNumber1, myNumber2;
        double squareRoot, highestValue, circleArea,randomNumber;
        double xComp, yComp, degrees, absoluteValue;

        System.out.println("Math Class Methods");
        System.out.println("******************\n");

        // round() Method
        myNumber1 = Math.round(7.5342);
        System.out.println("7.5342 is rounded to " + myNumber1 );
        myNumber2=Math.round(10.4999);
        System.out.println("10.4999 is rounded to " + myNumber2 + "\n");

        // sqrt() Method
        squareRoot=Math.sqrt(36);
        System.out.println("The squareroot of 36 is " + squareRoot + "\n");

        // max() Method
        highestValue=Math.max(10,20);
        System.out.println("The maximum value of 10,20 is " + highestValue + "\n");

        // This example uses several Math Methods and a Math constant - PI
        circleArea=Math.round(Math.PI * Math.pow(8,2));
        System.out.println("The area of a circle with a radius of 8 is " + circleArea + "\n");

        // random() Method
        randomNumber = Math.random();
        System.out.println("The random number generated is: " + randomNumber + "\n");
        
        //sin() and cos() Methods
        xComp = Math.cos(Math.PI / 3) * 5;
        yComp = Math.sin(Math.PI / 3) * 5;
        System.out.println("The vector 5[PI/3] (having magnitude 5 and angle Pi over 3) has an x-component of " + xComp + " and a y-component of " + yComp + "\n");
        
        //toDegrees() Method
        degrees = Math.toDegrees(Math.PI / 6);
        System.out.println("Pi/6 is " + degrees + " degrees\n");
        
        //abs() Method
        absoluteValue = Math.abs(-50.783);
        System.out.println("The absolute value of -50.783 is " + absoluteValue + "\n");
    }
}
