/*
Author: Darian
Date Modified: June 12, 2017
IDE: Netbeans 8.2
Program: Astronomap
File: Main entry point
 */
package astronomap;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;

/**
 *
 * @author Meep3_000
 */
public class Astronomap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AstronomapGame game = new AstronomapGame("Awoo");//Create game object
        try {
            AppGameContainer gc = new AppGameContainer(game, 800, 600, false);//Create game container
            //gc.setShowFPS(false);//Disable FPS view
            gc.start();//Start game
        } catch (SlickException ex) {
            Logger.getLogger(Astronomap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
