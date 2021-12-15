package endalos.fun.generator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static List<Rule> generateFromString(String ruleText){

        String[] splitRule = ruleText
                .replace("L","L ")
                .replace("R", "R ")
                .replace("F","F ")
                .replace("B", "B ")
                .split(" ");
        List<Rule> rules = new ArrayList<>();
        int length = splitRule.length;
        for(int i = 0; i < length; i++){
            Color startColor = Color.getHSBColor((float)(i)/length,1,1);
            Color endColor = Color.getHSBColor((float)(i+1)/length,1,1);
            if(i == 0){
                startColor = Color.WHITE;
                endColor = Color.BLACK;
            }
            else if(i == length-1)
                endColor = Color.WHITE;
            if(i == 1){
                startColor = Color.BLACK;
            }

            Rule rule = new Rule(startColor, splitRule[i], endColor);
            rules.add(rule);
        }
        return rules;
    }
}
