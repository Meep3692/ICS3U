/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeTest;

import gradeconverter8.GradeConverter8;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Test all possible grades
 * @author Meep3_000
 */
public class GradeTest {
    public static void main(String[] args){
        try {
            PipedInputStream in = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream(in);//Lets us put output into the program's input
            System.setIn(in);//Set sdtin to our piped stream
            for(int i = 0; i <= 100; i++){
                out.write((i + "\n").getBytes());//Write number to stream to be read by program
                GradeConverter8.percentageToAlpha();
            }
            for(int i = 0; i <= 100; i++){
                out.write((i + "\n").getBytes());//Write number to stream to be read by program
                GradeConverter8.percentageToLevel();
            }
        } catch (IOException ex) {
            Logger.getLogger(GradeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
