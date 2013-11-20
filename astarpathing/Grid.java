/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package astarpathing;

/**
 *
 * @author spex
 */
public class Grid {

    private int width;
    private int height;
    private boolean walls[][];
    private byte directions[][];
    private boolean searched[][];

    private int agentX = 2;
    private int agentY = 2;

    private boolean alternatingNodes = false;
    private boolean pathFound;
    private int pathX[];
    private int pathY[];

    private int targetX = 10;
    private int targetY = 10;

    public static final byte UP = 1;
    public static final byte DOWN = 2;
    public static final byte LEFT = 3;
    public static final byte RIGHT = 4;


    Grid(int tmpWidth, int tmpHeight){
        width = tmpWidth;
        height = tmpHeight;

        pathX = new int[0];
        pathY = new int[0];

        pathFound = false;
        walls = new boolean[width][height];
        directions = new byte[width][height];
        searched = new boolean[width][height];

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                walls[x][y] = false;


                directions[x][y] = 0;
                searched[x][y] = false;
            }
        }
    }

    
    
    public void doLogic(){


        if(walls[agentX][agentY]){
            walls[agentX][agentY] = false;
        }
        if(walls[targetX][targetY]){
            walls[targetX][targetY] = false;
        }



        if(pathFound == false){

            pathMethod1();


            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    if((searched[x][y] == false) &&
                        (directions[x][y] != 0)){
                        searched[x][y] = true;
                    }
                }
            }
        }

        if(directions[agentX][agentY] != 0){
            switch(directions[agentX][agentY]){
                case UP:
                    agentY--;
                    break;
                case DOWN:
                    agentY++;
                    break;
                case LEFT:
                    agentX--;
                    break;
                case RIGHT:
                    agentX++;
            }
        }
    }

    private void pathMethod1(){

        alternatingNodes = !alternatingNodes;
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                if((searched[x][y] == false) &&
                    (walls[x][y] == false)){

                    if(alternatingNodes){
                        if(x > 0){
                            if(searched[x-1][y] == true){
                                directions[x][y] = LEFT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                        if(x < width - 1){
                            if(searched[x+1][y] == true){
                                directions[x][y] = RIGHT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                    }


                    if(y > 0){
                        if(searched[x][y-1] == true){
                            directions[x][y] = UP;
                            if((agentX == x) &&
                                    (agentY == y)){
                                pathFound = true;
                                savePath();
                            }
                            continue;
                        }
                    }
                    if(y < height - 1){
                        if(searched[x][y+1] == true){
                            directions[x][y] = DOWN;
                            if((agentX == x) &&
                                    (agentY == y)){
                                pathFound = true;
                                savePath();
                            }
                            continue;
                        }
                    }
                    if(!alternatingNodes){
                        if(x > 0){
                            if(searched[x-1][y] == true){
                                directions[x][y] = LEFT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                        if(x < width - 1){
                            if(searched[x+1][y] == true){
                                directions[x][y] = RIGHT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                    }
                }
            }
        }

    }


    private void pathMethod2(){

        alternatingNodes = !alternatingNodes;
        int lowestFX = -1;
        int lowestFY = -1;
        int lowestF = 9999;


        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){

                if((searched[x][y] == false) &&
                    (walls[x][y] == false)){

                    if((y > 0) && (searched[x][y-1] == true)){
                        int xDifference, yDifference, targetDistance;

                        /////////////asdfasdfasdfasdfasdf
                        /////////asdfasdfasdf
                        /////////asdfasdfdsaf
                        //////////asdfasdfsadfsadf
                        //////////asdfsdf

                    }
                    if(y < height - 1){
                        if(searched[x][y+1] == true){
                            directions[x][y] = DOWN;
                            if((agentX == x) &&
                                    (agentY == y)){
                                pathFound = true;
                                savePath();
                            }
                            continue;
                        }
                    }
                    if(!alternatingNodes){
                        if(x > 0){
                            if(searched[x-1][y] == true){
                                directions[x][y] = LEFT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                        if(x < width - 1){
                            if(searched[x+1][y] == true){
                                directions[x][y] = RIGHT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                    }
                }
            }
        }

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){

                if((searched[x][y] == false) &&
                    (walls[x][y] == false)){

                    if(alternatingNodes){
                        if(x > 0){
                            if(searched[x-1][y] == true){
                                directions[x][y] = LEFT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                        if(x < width - 1){
                            if(searched[x+1][y] == true){
                                directions[x][y] = RIGHT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                    }


                    if(y > 0){
                        if(searched[x][y-1] == true){
                            directions[x][y] = UP;
                            if((agentX == x) &&
                                    (agentY == y)){
                                pathFound = true;
                                savePath();
                            }
                            continue;
                        }
                    }
                    if(y < height - 1){
                        if(searched[x][y+1] == true){
                            directions[x][y] = DOWN;
                            if((agentX == x) &&
                                    (agentY == y)){
                                pathFound = true;
                                savePath();
                            }
                            continue;
                        }
                    }
                    if(!alternatingNodes){
                        if(x > 0){
                            if(searched[x-1][y] == true){
                                directions[x][y] = LEFT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                        if(x < width - 1){
                            if(searched[x+1][y] == true){
                                directions[x][y] = RIGHT;
                                if((agentX == x) &&
                                        (agentY == y)){
                                    pathFound = true;
                                    savePath();
                                }
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }

    private int makePositive(int input){
        if(input >=0){
            return input;
        }else{
            return -input;
        }
    }

    private void savePath(){

        if((agentX == targetX) && (agentY == targetY)){
            //DO NOTHING
        }else{
            int tmpX = agentX;
            int tmpY = agentY;

            int tmpPathX[] = new int[width * height];
            int tmpPathY[] = new int[width * height];

            int pathDistance = 0;

            do{
                tmpPathX[pathDistance] = tmpX;
                tmpPathY[pathDistance] = tmpY;


                pathDistance++;

                switch(directions[tmpX][tmpY]){
                    case UP:
                        tmpY--;
                        break;
                    case DOWN:
                        tmpY++;
                        break;
                    case LEFT:
                        tmpX--;
                        break;
                    case RIGHT:
                        tmpX++;
                }


            }while((tmpX != targetX) || (tmpY != targetY) );

            pathX = new int[pathDistance];
            pathY = new int[pathDistance];
            for(int i = 0; i < pathDistance; i++){
                pathX[i] = tmpPathX[i];
                pathY[i] = tmpPathY[i];
            }
            System.out.println(pathDistance);
        }
    }













    public boolean getPath(int x, int y){
        for(int i = 0; i < pathX.length; i++){
            if((pathX[i] == x) && (pathY[i] == y)){
                return true;
            }
        }
        return false;
    }


    public int getTargetX(){
        return targetX;
    }
    public int getTargetY(){
        return targetY;
    }

    public void setTargetX(int newTarget){
        targetX = newTarget;
    }
    public void setTargetY(int newTarget){
        targetY = newTarget;
    }


    public int getAgentX(){
        return agentX;
    }
    public int getAgentY(){
        return agentY;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void resetAll(){
        pathFound = false;
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                walls[x][y] = false;
                directions[x][y] = 0;
                searched[x][y] = false;
            }
        }
    }
    public void resetDirectionsAndSearched(){
        pathFound = false;
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                directions[x][y] = 0;
                searched[x][y] = false;
            }
        }
    }

    public boolean getWall(int x, int y){
        return walls[x][y];
    }
    public byte getDirection(int x, int y){
        return directions[x][y];
    }
    public boolean getSearched(int x, int y){
        return searched[x][y];
    }

    public void setWall(int x, int y, boolean newWall){
        if(x >= walls.length){
            return;
        }
        walls[x][y] = newWall;
    }
    public void setDirection(int x, int y, byte newDirection){
        directions[x][y] = newDirection;
    }
    public void setSearched(int x, int y, boolean newSearched){
        if(x >= walls.length){
            return;
        }
        searched[x][y] = newSearched;
    }
}
