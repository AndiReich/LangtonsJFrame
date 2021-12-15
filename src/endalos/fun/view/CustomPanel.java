package endalos.fun.view;

import endalos.fun.controller.LoopEngine;
import endalos.fun.misc.Config;
import endalos.fun.model.BoardCoordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CustomPanel extends JPanel {
    private int scale = Config.instance.scale;
    private Graphics2D g;
    Color[][] board;

    @Override
    protected void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        g = (Graphics2D) g1;
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        //g.draw(new Ellipse2D.Float(x * w + w / 2f - r, y * h + h / 2f - r, 2 * r, 2 * r));
        //if(LoopEngine.getInstance() != null && LoopEngine.getInstance().isRunning())
            drawPanel();
    }

    public void drawPanel(){
        Color[][] boardCopy = new Color[Config.instance.height/scale][Config.instance.width/scale];
        for(int y = 0; y < board[0].length; y++){
            boardCopy[y] = Arrays.copyOf(board[y], board[y].length);
        }
        for(int y = 0; y < boardCopy.length; y++){
            for(int x = 0; x < boardCopy[0].length; x++){
                g.setColor(board[y][x]);
                g.fillRect((x*scale),(y*scale),scale,scale);
            }
        }
    }

    public void setBoard(Color[][] board) {
        this.board = board;
    }
}