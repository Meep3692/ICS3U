/*
Author: Darian
Date Modified: June 19, 2017
IDE: Netbeans 8.2
Program: Astronomap
File: Game
 */
package astronomap;

import java.time.*;
import org.newdawn.slick.*;

/**
 *
 * @author Meep3_000
 */
public class AstronomapGame extends BasicGame {
    
    private Body[] bodies;
    private Body sun;
    private double scale;
    private double zoom;
    private double offsetX;
    private double offsetY;
    private String tracking;
    private LocalDateTime time;
    
    public AstronomapGame(String title) {
        super(title);
        offsetX = -400;
        offsetY = -300;
        scale = 1;
        tracking = "Test";
        bodies = new Body[2];
        time = LocalDateTime.now();
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        sun = new Body("Sun", 695700000, 0, 1, 0, null, "res/img/sun.png");
        //Mercury
        Body mercury = new Body("Mercury", 2439700, 0.387098, 0.00000044151303815033068425510443134923, 0.62024948598282, sun, "res/img/mercury.png");
        sun.addSatellite(mercury);
        //Venus
        Body venus = new Body("Venus", 6051800, 0.7233265, 0.000002447844395187207535155851098977, -1.6642731079535, sun, "res/img/venus.png");
        sun.addSatellite(venus);
        //Earth
        Body earth = new Body("Earth", 6371000, 1, 0.0000030034900554444264235041117778859, 1.7634970854573, sun, "res/img/earth.png");
        Body luna = new Body("Luna (the Moon)", 1737100, 0.00257, 0.000000036942927681966445009100574867997, 5.0840761513749887095106461236133, earth, "res/img/luna.png");
        earth.addSatellite(luna);
        sun.addSatellite(earth);
        //Mars
        Body mars = new Body("Mars", 3389500, 1.5237, 0.00000032137343593255362731493996023379, 0.3503142122354, sun, "res/img/mars.png");
        Body phobos = new Body("Phobos", 11266.7, 0.00006267469, 0.0000000000000053605389462555489478774335778174, 0, mars, "res/img/phobos.png");//Not going to do offset for most moons, can't find data
        mars.addSatellite(phobos);
        Body deimos = new Body("Deimos", 6200, 0.0001568418046, 0.0000000000000007422118532422, 0, mars, "res/img/deimos.png");
        mars.addSatellite(deimos);
        sun.addSatellite(mars);
        //Jupiter
        Body jupiter = new Body("Jupiter", 69911000, 5.20260, 1/1047, -2.7502823751276, sun, "res/img/jupiter.png");
        Body metis = new Body("Metis", 21500, 0.000855627152, 0.000000000000018100275516, 0, jupiter, "res/img/metis.png");
        jupiter.addSatellite(metis);
        Body adrastea = new Body("Adrastea", 8200, 0.000862311739, 0, 0, jupiter, "res/img/adrastea.png");//Couldn't find mass info, aproximated to 0. It works out in the end
        jupiter.addSatellite(adrastea);
        Body amalthea = new Body("Amalthea", 83500, 0.00121235575848, 0.00000000000104579369648, 0, jupiter, "res/img/amalthea.png");
        jupiter.addSatellite(amalthea);
        Body thebe = new Body("Thebe", 49300, 0.00148323635, 0, 0, jupiter, "res/img/thebe.png");
        jupiter.addSatellite(thebe);
        Body io = new Body("Io", 1821600, 0.002819, 0.00000004490848296995278, 0, jupiter, "res/img/io.png");
        jupiter.addSatellite(io);
        Body europa = new Body("Europa", 1560800, 0.0044846895, 0.00000002413291634272764, 0, jupiter, "res/img/europa.png");
        jupiter.addSatellite(europa);
        Body ganymede = new Body("Ganymede", 2634100, 0.007155182056, 0.00000007450777301989, 0, jupiter, "res/img/ganymede.png");
        jupiter.addSatellite(ganymede);
        Body callisto = new Body("Callisto", 2410300, 0.01258507218, 0.0000000540965951059278, 0, jupiter, "res/img/callisto.png");
        jupiter.addSatellite(callisto);
        sun.addSatellite(jupiter);
        //Saturn
        Body saturn = new Body("Saturn", 58232000, 9.5549, 0.00028576312756316004, 0.65625087326943, sun, "res/img/saturn.png");
        Body mimas = new Body("Mimas", 189200, 0.00124025161, 0.000000000018850934164483, 0, saturn, "res/img/mimas.png");
        saturn.addSatellite(mimas);
        Body enceladus = new Body("Enceladus", 252100, 0.00159058414, 0.000000000054311887827482005, 0, saturn, "res/img/enceladus.png");
        saturn.addSatellite(enceladus);
        
        sun.addSatellite(saturn);
        //Uranus
        Body uranus = new Body("Uranus", 25362000, 19.2184, 0.00004364680326511001, -3.0484053918209, sun, "res/img/uranus.png");
        
        sun.addSatellite(uranus);
        //Neptune
        Body neptune = new Body("Neptune", 24622000, 30.110387, 0.0000515, -2.1200428361384, sun, "res/img/neptune.png");
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        time = LocalDateTime.now();
        Input input = gc.getInput();
        
        if(input.isKeyDown(Input.KEY_UP)){
            offsetY -= 1/scale;
            tracking = "";
        }
        if(input.isKeyDown(Input.KEY_DOWN)){
            offsetY += 1/scale;
            tracking = "";
        }
        if(input.isKeyDown(Input.KEY_LEFT)){
            offsetX -= 1/scale;
            tracking = "";
        }
        if(input.isKeyDown(Input.KEY_RIGHT)){
            offsetX += 1/scale;
            tracking = "";
        }
        if(input.isKeyDown(Input.KEY_PRIOR)){
            zoom += 0.1;
            scale = Math.pow(2, zoom);
        }
        if(input.isKeyDown(Input.KEY_NEXT)){
            zoom -= 0.1;
            scale = Math.pow(2, zoom);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        //System.out.println("Start draw");
        drawBody(sun, 0, 0, gc, grphcs);
        //System.out.println("End draw");
    }
    
    private void drawBody(Body body, double originX, double originY, GameContainer gc, Graphics g){
        //System.out.println("\tDraw: " + body.getName());
        double distance = body.getDistance() * 149597870700.0;//Convert AU distance to meters
        double angle = body.offset(time.toInstant(ZoneOffset.UTC).toEpochMilli() / 31556952220.0);//Get number of years since epoch (exact)
        double xCoord = (distance * Math.cos(angle)) + originX;//Find coords in space
        double yCoord = -(distance * Math.sin(angle)) + originY;//Compensate for inverted y on computers
        double xScaled = xCoord * scale;//Scale coords with zoom
        double yScaled = yCoord * scale;
        if(body.getName().equals(tracking)){//Put camera at planet if tracked
            offsetX = xCoord;
            offsetY = yCoord;
        }
        double offsetScaledX = (offsetX * scale) - (gc.getWidth() / 2);//Find scaled offset
        double offsetScaledY = (offsetY * scale) - (gc.getHeight() / 2);
        //Find corners
        float x1 = (float)((xScaled - (body.getRadius() * scale)) - offsetScaledX);
        float y1 = (float)((yScaled - (body.getRadius() * scale)) - offsetScaledY);
        float x2 = (float)((xScaled - (body.getRadius() * scale)) - offsetScaledX);
        float y2 = (float)((yScaled + (body.getRadius() * scale)) - offsetScaledY);
        float x3 = (float)((xScaled + (body.getRadius() * scale)) - offsetScaledX);
        float y3 = (float)((yScaled + (body.getRadius() * scale)) - offsetScaledY);
        float x4 = (float)((xScaled + (body.getRadius() * scale)) - offsetScaledX);
        float y4 = (float)((yScaled - (body.getRadius() * scale)) - offsetScaledY);
         
        /*System.out.println("\t\tOrbit coords: " + distance + "[" + angle + "], (" + xCoord + ", " + yCoord + ")");//Debug stuff
        System.out.println("\t\tScreenPos: (" + (xScaled - offsetScaledX) + ", " + (yScaled - offsetScaledY) + ")");
        System.out.println("\t\tCorners: (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + "), (" + x4 + ", " + y4 + ")");*/
        body.getImage().drawWarped(x1, y1, x2, y2, x3, y3, x4, y4);//Draw body at corners
        g.drawString(body.getName(), x3, y3);//Render name
        
        Body[] satalites = body.getSatalites();//Get body's satalites
        if(satalites.length > 0){//If it has any
            for(Body satalite : satalites){
                drawBody(satalite, xCoord, yCoord, gc, g);//Render them too
            }
        }
    }
    
}
