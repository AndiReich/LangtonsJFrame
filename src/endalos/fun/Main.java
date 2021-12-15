package endalos.fun;

import endalos.fun.controller.LoopEngine;
import endalos.fun.generator.RuleSingleton;
import endalos.fun.model.Ant;
import endalos.fun.model.BoardCoordinates;
import endalos.fun.view.UserInterface;

//Cool rules:
    /*
    basic: LR / RL
    fast highway: LLR / RRL
    heart?: LLRR / RRLL
    palace: RLLR / LRRL
    multicolor highway: RLRLRLLRLR / LRLRLRRLRL
    straight highway: RRLLLRRRLRRR / LLRRRLLLRLLL
    fill board: RRLRR / LLRLL
    spiral: LRRRRLLLRRR / RLLLLRRRLLL
    hearth + fill: LRRRRLLRRL / you get the idea...
    fill + highway: LRRRRLLRRLRRRRRR
    strange patern: LRRRRLLRRLRRRRRRRRRRRRRR
     */
public class Main {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        RuleSingleton.getInstance().setRules("RL");
        UserInterface userInterface = new UserInterface();

        BoardCoordinates boardCoordinates = new BoardCoordinates();
        userInterface.setBoard(boardCoordinates.getBoard());
        Ant ant = new Ant();
        ant.setBoardCoordinates(boardCoordinates);
        /*System.out.println(ant.getOrientation().toString());
        for(int i = 0; i < 8; i++){
            ant.step();
            System.out.println();
        }
        userInterface.repaint();
*/
        LoopEngine.init(userInterface ,boardCoordinates);
    }
}
