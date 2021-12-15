package endalos.fun.generator;

import java.awt.*;

public class Rule {

    private Color startColor;
    private String direction;
    private Color nextColor;

    public Rule(Color startColor, String direction, Color nextColor){
        this.startColor = startColor;
        this.direction = direction;
        this.nextColor = nextColor;
    }

    public Color getStartColor() {
        return startColor;
    }

    public void setStartColor(Color startColor) {
        this.startColor = startColor;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Color getNextColor() {
        return nextColor;
    }

    public void setNextColor(Color nextColor) {
        this.nextColor = nextColor;
    }
}
