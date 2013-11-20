
package astarpathing;

/**
 *
 * @author spex
 */

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

public class Printer {

    //use this as a double buffer
    BufferedImage backbuffer;
    //Create the graphics printer
    private Graphics2D g2d;
    //Declare variables
    int screenWidth;
    int screenHeight;


    Printer(int W, int H){
        
        screenWidth = W;
        screenHeight = H;

        //create the back buffer for smooth graphics
        backbuffer = new BufferedImage(screenWidth,screenHeight,BufferedImage.TYPE_INT_RGB);
        g2d = backbuffer.createGraphics();
    }

    public void refresh(Graphics g){
        g.drawImage(backbuffer, 0, 0, null);
    }

    public void cls(){
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, screenWidth, screenHeight);
    }

    public void printGrid(Grid grid){

        int theorySC = screenHeight-20;
        double printRatio = (double)theorySC/grid.getHeight();

//        g2d.setColor(Color.BLACK);
//        g2d.fillRect(0, 0, theorySC, theorySC + 20);

        for(int x = 0; x < grid.getWidth(); x++){
            for(int y = 0; y < grid.getHeight(); y++){

                g2d.setColor(Color.GRAY);

                if((grid.getAgentX() == x) &&
                        (grid.getAgentY() == y)){
                    g2d.setColor(Color.GREEN);
                }else if((grid.getTargetX() == x) &&
                        (grid.getTargetY() == y)){
                    g2d.setColor(Color.RED);
                }else if(grid.getWall(x, y)){
                    g2d.setColor(Color.BLUE);
                }else if(grid.getPath(x, y)){
                    g2d.setColor(Color.ORANGE);
                }
                g2d.fillRect((int)((x) * printRatio),(int)( (y) * printRatio) + 20,
                        (int)(printRatio) + 1, (int)(printRatio) + 1);

                g2d.setColor(Color.DARK_GRAY);
                if(grid.getDirection(x, y) != 0){
                    switch( grid.getDirection(x, y)){
                        case Grid.UP:
                            g2d.fillRect((int)((x) * printRatio),(int)( (y) * printRatio) + 20,
                        (int)(printRatio), (int)(printRatio/3));
                            break;
                        case Grid.DOWN:
                            g2d.fillRect((int)((x) * printRatio),(int)( (y) * printRatio + ((printRatio*2)/3)) + 20,
                        (int)(printRatio), (int)(printRatio/3));
                            break;
                        case Grid.LEFT:
                            g2d.fillRect((int)((x) * printRatio),(int)( (y) * printRatio) + 20,
                        (int)(printRatio/3), (int)(printRatio));
                            break;
                        case Grid.RIGHT:
                            g2d.fillRect((int)((x) * printRatio + ((printRatio * 2)/3)),(int)( (y) * printRatio) + 20,
                        (int)(printRatio/3), (int)(printRatio));

                    }
                }
            }
        }
    }
}
