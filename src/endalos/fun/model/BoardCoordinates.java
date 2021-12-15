package endalos.fun.model;

import endalos.fun.generator.RuleSingleton;
import endalos.fun.misc.Config;

import java.awt.*;

public class BoardCoordinates {
    private Color[][] board;
    private int width = Config.instance.width;
    private int height = Config.instance.height;
    private int scale = Config.instance.scale;

    public BoardCoordinates(){
        board = new Color[height/scale][width/scale];
        clear();
    }
    public Color[][] getBoard(){
        return board;
    }

    public void changeBlock(Color color, Coordinate coordinate){
        board[coordinate.getY()][coordinate.getX()] = color;
    }

    public void clear() {
        Color[][] boardTemp = new Color[height/scale][width/scale];
        for(int x = 0; x < (width/scale); x++){
            for(int y = 0; y < (height/scale); y++){
                board[y][x] = Color.WHITE;
            }
        }
    }
}
