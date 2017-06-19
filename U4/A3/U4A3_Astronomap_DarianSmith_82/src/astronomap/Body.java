/*
Author: 
Date Modified: 
IDE: Netbeans 8.2
Program: 
File: 
 */
package astronomap;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * An astronomical body
 * @author Meep3_000
 */
public class Body {
    private static final double G = 4 * Math.PI * Math.PI;
    
    private String name;//Name of body
    private double radius;//Radius of body in meters
    private double distance;//Distance from centre of system in AU
    private double mass;
    private double epochOffset;//Offset in rads at epoch
    private Body parent;
    private Image img;//Image of body
    
    private ArrayList<Body> satellites;
    
    /**
     * Create a new body
     * @param name Name of body
     * @param radius Radius of body in meters
     * @param distance Distance from centre of system in AU
     * @param mass Mass of body in solar masses
     * @param epochOffset Offset in rads at epoch
     * @param orbitingMass The body this body is orbiting
     * @param imagePath Path to image file
     * @throws SlickException Failed to load image
     */
    public Body(String name, double radius, double distance, double mass, double epochOffset, Body orbitingMass, String imagePath) throws SlickException{
        this.name = name;
        this.radius = radius;
        this.distance = distance;
        this.mass = mass;
        this.epochOffset = epochOffset;
        this.parent = orbitingMass;
        img = new Image(imagePath);
        satellites = new ArrayList<>();
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
        return Math.sqrt(((4 * Math.PI * Math.PI) / (G * (mass + parent.mass))) * (distance * distance * distance));
    }
    
    public Body[] getSatalites(){
        Body[] array = new Body[satellites.size()];
        return satellites.toArray(array);
    }
    
    public void addSatellite(Body body){
        satellites.add(body);
    }
    
    public double getMass(){
        return mass;
    }
    
    /**
     * Get offset in orbit at time
     * @param time Time since Jan 1, 1970 00:00 UTC in years
     * @return Offset in orbit in radians
     */
    public double offset(double time){
        if(distance == 0)//Are we the sun?
            return 0;//Avoid NaNs
        double period = Math.sqrt(((4 * Math.PI * Math.PI) / (G * (mass + parent.mass))) * (distance * distance * distance));//Find orbital period (oh boy, it's kepler)
        double timeOff = time % period;
        double offset = ((2 * Math.PI) * (1 / period) * timeOff) + epochOffset;//Find offset in orbit
        return offset;//Return offset
    }
}
