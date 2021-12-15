package endalos.fun.controller;

import endalos.fun.misc.Config;
import endalos.fun.model.Ant;
import endalos.fun.model.BoardCoordinates;
import endalos.fun.view.UserInterface;

public  class LoopEngine {
    private Thread t;
    private static LoopEngine instance;
    private UserInterface userInterface;
    private Ant ant;
    private BoardCoordinates boardCoordinates;
    private boolean isRunning = false;

    private LoopEngine(UserInterface userInterface, BoardCoordinates boardCoordinates) {
        this.userInterface = userInterface;
        this.boardCoordinates = boardCoordinates;
    }

    public void start(){
        //credit @Luzian
        if(t!= null && t.isAlive()){
            isRunning = false;
            while(t.isAlive()){

            }

        }

        int targetFps = Config.instance.targetFps;


        t = new Thread(() ->{
            int fps = 0;
            int counter = 0;
            isRunning = true;
            boardCoordinates.clear();
            this.ant = new Ant();
            ant.setBoardCoordinates(boardCoordinates);
            long lastTime = System.nanoTime();
            long frameTime = System.nanoTime();
            boolean stop = false;
            while(!stop && isRunning){
                long before = System.nanoTime();
                stop = ant.step();
                userInterface.repaint();
                long after = System.nanoTime();
                userInterface.incrementStepCount();
                counter++;
                //System.out.println(counter + " | " + (after-before));

                if (System.nanoTime() >= lastTime + 1e9) {
                    fps = counter;
                    counter = 0;
                    lastTime = System.nanoTime();

                    System.out.println("fps: " + fps);

                }


                if (targetFps != 0) {
                    long start = System.nanoTime();
                    long delay = (long) ((1_000_000_000.0 / targetFps)) - (System.nanoTime() - frameTime);

                    while (start + delay >= System.nanoTime() && isRunning);

                    frameTime = System.nanoTime();
                }
            }
        });
        t.start();
    }

    public static void init(UserInterface userInterface, BoardCoordinates boardCoordinates){
        instance = new LoopEngine(userInterface, boardCoordinates);
    }
    public static LoopEngine getInstance () {
        return LoopEngine.instance;
    }

    public boolean isRunning() {
        return isRunning && instance != null;
    }

}
