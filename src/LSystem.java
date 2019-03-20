import java.util.HashMap;

public class LSystem {
    private Turtle turtle;
    private String generation;
    private int numGenerations;
    private HashMap<String, String> productionRules;

    public LSystem(String axiom, HashMap<String,String> productionRules, float startingLength, float theta){
        this.turtle = new Turtle(startingLength, theta);
        this.generation = axiom;
        this.numGenerations = 0;
        this.productionRules = productionRules;
    }

    public void render(){
        for(int i = 0; i < generation.length(); i++){
            turtle.render(generation.charAt(i),numGenerations);
        }
    }

    public void generateNewSentence(){
        StringBuffer nextgen = new StringBuffer();
        for(int i = 0; i < generation.length(); i++){
            char c = generation.charAt(i);
            String replacement = productionRules.get(Character.toString(c));
            nextgen.append(replacement);
        }
        generation = nextgen.toString();
        numGenerations++;
    }

}
