/*
Author: 
Date Modified: 
IDE: Netbeans 8.2
Program: 
File: 
 */
package astronomap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * An astronomical body
 * @author Meep3_000
 */
public class Body {
    private String name;//Name of body
    private double radius;//Radius of body in meters
    private double distance;//Distance from centre of system in AU
    private double epochOffset;//Offset in rads at epoch
    private Image img;//Image of body
    
    /**
     * Create a new body
     * @param name Name of body
     * @param radius Radius of body in meters
     * @param distance Distance from centre of system in AU
     * @param epochOffset Offset in rads at epoch
     * @param imagePath Path to image file
     * @throws SlickException Failed to load image
     */
    public Body(String name, double radius, double distance, double epochOffset, String imagePath) throws SlickException{
        this.name = name;
        this.radius = radius;
        this.distance = distance;
        this.epochOffset = epochOffset;
        img = new Image(imagePath);
    }
    
    /**
     * Get name of the body
     * @return Name of body
     */
    public String getName(){
        return name;
    }
    
    /**
     * Get the radius of the body
     * @return Radius in meters
     */
    public double getRadius(){
        return radius;
    }
    
    /**
     * Get the distance from the centre of the system
     * @return Distance in AU
     */
    public double getDistance(){
        return distance;
    }
    
    /**
     * Get image of body
     * @return Slick2D Image of body
     */
    public Image getImage(){
        return img;
    }
    
    public double getPeriod(){
        return Math.sqrt(distance * distance * distance);
    }
    
    /**
     * Get offset in orbit at time
     * @param time Time since Jan 1, 1970 00:00 UTC in years
     * @return Offset in orbit in radians
     */
    public double offset(double time){
        double period = Math.sqrt(distance * distance * distance);//Find orbital period
        double offset = ((2 * Math.PI * time) / period) + epochOffset;//Find offset in orbit
        return offset;//Return offset
    }
}
