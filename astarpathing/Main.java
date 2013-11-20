/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package astarpathing;


/**
 *
 * @author spex
 *
 * The main function for the battleship game.
 *
 */

import javax.swing.JFrame;//Gives a frame that we can draw to
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics;
import java.util.Random;

public class Main extends JFrame  implements KeyListener, MouseListener, MouseMotionListener{

    //The height and width of the frame
    static private int Width = 800;
    static private int Height = 600;

    //Our randomizer
    Random r = new Random();

    //The printer for the graphics in this game.
    public Printer p = new Printer(Width, Height);

    //The grid that is used for the application
    public Grid grid = new Grid(50,50);

    //If the application is done
    boolean done = false;

    //Main startup function
    public static void main(String[] args) {
        System.out.println("Starting new Instance");
        Main m = new Main();
        m.init();
        m.run();
    }

    public void init(){
        //Set the screen dimensions.
        System.out.println("Setting screen size to " + Width + ',' + Height);
        setSize(Width,Height);
        System.out.println("Making screen visible....");
        setVisible(true);

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public void run(){
        System.out.println("Running....");

        long lastTime = System.currentTimeMillis();
        int i = 0;
        do{

            //Print the screen
            p.printGrid(grid);
            repaint();

            //Do timer
            do{
            }while(lastTime + 30 > System.currentTimeMillis());
            lastTime = System.currentTimeMillis();

            //Do key input

            //Do logic
            grid.doLogic();

        }while(done == false);
        System.exit(0);
    }

    public void update(Graphics g){
        paint(g);
    }

    public void paint(Graphics g){
        p.refresh(g);;
    }



    //Key Events
    public void keyTyped(KeyEvent e){

    }
    public void keyPressed(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){

    }


    //Mouse Events
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == e.BUTTON1){
            if(e.isShiftDown()){
                double printRatio = (double)(Height - 20)/grid.getHeight();
                grid.setWall((int)(e.getX()/printRatio), (int)((e.getY() - 20)/printRatio), false);
            }else{
                double printRatio = (double)(Height - 20)/grid.getHeight();
                grid.setWall((int)(e.getX()/printRatio), (int)((e.getY() - 20)/printRatio), true);
            }
        }else{
            double printRatio = (double)(Height - 20)/grid.getHeight();
            grid.setTargetX((int)(e.getX()/printRatio));
            grid.setTargetY((int)((e.getY() - 20)/printRatio));
            grid.resetDirectionsAndSearched();
            grid.setSearched((int)(e.getX()/printRatio), (int)((e.getY() - 20)/printRatio), true);
        }
    }

    //Mouse Movement Events
    public void mouseMoved(MouseEvent e){
    }
    public void mouseDragged(MouseEvent e){
        if(e.getButton() == e.BUTTON1){
            if(e.isShiftDown()){
                double printRatio = (double)(Height - 20)/grid.getHeight();
                grid.setWall((int)(e.getX()/printRatio), (int)((e.getY() - 20)/printRatio), false);
            }else{
                double printRatio = (double)(Height - 20)/grid.getHeight();
                grid.setWall((int)(e.getX()/printRatio), (int)((e.getY() - 20)/printRatio), true);
            }
        }
    }
}
