package endalos.fun.model;

import endalos.fun.generator.Generator;
import endalos.fun.generator.Rule;
import endalos.fun.generator.RuleSingleton;
import endalos.fun.misc.Config;

import java.awt.*;
import java.util.Arrays;

public class Ant {
    private Coordinate coordinate;
    private Orientation orientation;
    private int orientationIndex;
    private BoardCoordinates boardCoordinates;
    private Orientation[] flow = Config.instance.orientationFlow;
    private int z = 0;
    public Ant(){
        this.orientation = Orientation.up;
        orientationIndex = Arrays.asList(flow).indexOf(orientation);
    }

    public void setBoardCoordinates(BoardCoordinates boardCoordinates) {
        this.boardCoordinates = boardCoordinates;
        int x = (Config.instance.width/Config.instance.scale)/2;
        int y = (Config.instance.height/Config.instance.scale)/2;
        this.coordinate = new Coordinate(x,y);
        this.boardCoordinates = boardCoordinates;
        //boardCoordinates.changeBlock(RuleSingleton.getInstance().getRules().get(0).getNextColor(),coordinate);
    }

    public boolean step(){
        int x = this.coordinate.getX();
        int y = this.coordinate.getY();
        int scale = Config.instance.scale;
        if((x > 0) && (x < ((Config.instance.width/scale)))  &&  (y < ((Config.instance.height/scale))) && (y > 0)){
            Color color = boardCoordinates.getBoard()[y][x];
            for(Rule rule : RuleSingleton.getInstance().getRules()){
                if(color.equals(rule.getStartColor())){
                    if(rule.getDirection().equals("L"))
                        turnLeft();
                    else if(rule.getDirection().equals("R"))
                        turnRight();
                    else if(rule.getDirection().equals("F"));
                    else if(rule.getDirection().equals("B"))
                        turn180();
                    else
                        System.err.println("WRONG");

                    boardCoordinates.changeBlock(rule.getNextColor(),coordinate);
                    walkOrientation(x,y);
                    break;
                }
            }
        }
        else{
            return true;
        }
        return false;
    }

    private void walkOrientation(int x, int y){
        if(orientation == Orientation.up){
            walkUp(y);
        }
        else if(orientation == Orientation.down){
            walkDown(y);
        }
        else if(orientation == Orientation.left){
            walkLeft(x);
        }
        else if(orientation == Orientation.right){
            walkRight(x);
        }
    }

    private void walkLeft(int x){
        this.coordinate.setX(x-1);
    }
    private void walkRight(int x){
        this.coordinate.setX(x+1);
    }
    private void walkUp(int y){
        this.coordinate.setY(y-1);
    }
    private void walkDown(int y){
        this.coordinate.setY(y+1);
    }
    public void turnRight(){
        orientationIndex--;
        if(orientationIndex < 0){
            orientationIndex = flow.length-1;
        }
        orientation = flow[orientationIndex];
    }
    public void turnLeft(){
        orientationIndex++;
        if(orientationIndex >= flow.length){
            orientationIndex = 0;
        }
        orientation = flow[orientationIndex];
    }
    public void turn180(){
        turnRight();
        turnRight();
    }


    public Orientation getOrientation(){
        return this.orientation;
    }
}
