/*
Author: Darian
Date Modified: June 12, 2017
IDE: Netbeans 8.2
Program: Astronomap
File: Game
 */
package astronomap;

import java.time.*;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Meep3_000
 */
public class AstronomapGame extends BasicGame {
    
    private Body[] bodies;
    private double scale;
    private double offsetX;
    private double offsetY;
    private String tracking;
    private LocalDateTime time;
    
    private Image ping;
    
    public AstronomapGame(String title) {
        super(title);
        offsetX = -400;
        offsetY = -300;
        scale = 0.0001;
        tracking = "Test";
        bodies = new Body[2];
        time = LocalDateTime.now();
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        bodies[0] = new Body("Test", 50, 0.00001, 0, "res/img/earth.png");
        bodies[1] = new Body("Test2", 50, 0.00002, 0, "res/img/earth.png");
        ping = new Image("res/img/ping.png");
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        time = LocalDateTime.now();
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        for(Body body : bodies){
            double distance = body.getDistance() * 149597870700.0;//Convert AU distance to meters
            System.out.println(body.getPeriod() * 31556952.22);
            double angle = body.offset(time.toInstant(ZoneOffset.UTC).toEpochMilli() / 31556952220.0);//Get number of years since epoch (exact)
            double xCoord = (distance * Math.cos(angle));
            double yCoord = (distance * Math.sin(angle));
            double xScaled = xCoord * scale;
            double yScaled = yCoord * scale;
            if(body.getName().equals(tracking)){
                offsetX = xScaled - (gc.getWidth() / 2);
                offsetY = yScaled - (gc.getHeight() / 2);
            }
            System.out.println("x:" + (float)(((xCoord - body.getRadius()) * scale) - offsetX) + " y:" + (float)(((yCoord - body.getRadius()) * scale) - offsetY) + " scale:" + scale);
            body.getImage().draw((float)(xScaled - body.getRadius() - offsetX), (float)(yScaled = body.getRadius() - offsetY), (float)scale);
            ping.draw((float)((xCoord * scale) - 16 - offsetX), (float)((yCoord * scale) - 16 - offsetY));
        }
    }
    
}
