package endalos.fun.generator;

import java.util.List;

public class RuleSingleton {
    private static RuleSingleton instance;
    private List<Rule> rules;

    private RuleSingleton() {

    }
    public static synchronized RuleSingleton getInstance(){
        if(RuleSingleton.instance == null){
            RuleSingleton.instance = new RuleSingleton();
        }
        return RuleSingleton.instance;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(String inputText) {
        this.rules = Generator.generateFromString(inputText);
    }
}
