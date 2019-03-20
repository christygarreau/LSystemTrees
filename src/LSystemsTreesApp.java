import processing.core.PApplet;
import java.util.HashMap;

public class LSystemsTreesApp extends PApplet {
    //order of methods 1) main 2) constructor 3)processing methods //getapp at bottom
    public static LSystemsTreesApp app;
    private LSystem lSystem;
    private int regenerations;

    public static void main(String[] args) {
        PApplet.main("LSystemsTreesApp");
    }

    public LSystemsTreesApp() {
        app = this;
        regenerations = 0;
    }

    public void settings() {
        size(1000, 500);
    }

    public void setup(){
        this.lSystem = getRandomTry();
    }

    public void draw(){
        background(255);
        translate(width / 2, height);
        rotate(-PI / 2);
        lSystem.render();
        noLoop();
    }

    public void mouseClicked(){
        //if (regenerations < 5) {
            lSystem.generateNewSentence();
            regenerations++;
            redraw();
        //}
    }
    /*
    private LSystem get3_2_d (){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "FF+[+F−F−F]−[−F+F+F]");
        ruleset.put("G", "G");
        ruleset.put("+", "+");
        ruleset.put("-", "-");
        ruleset.put("[", "[");
        ruleset.put("]", "]");
        LSystem lSystem = new LSystem("F",ruleset,height/4, radians(40));
        return lSystem;
    }
    */

    ///*
    private LSystem getRandomTry(){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F","F[+F]F[-F]F");
        ruleset.put("G", "G");
        ruleset.put("+", "+");
        ruleset.put("-", "-");
        ruleset.put("[", "[");
        ruleset.put("]", "]");
        LSystem lSystem = new LSystem("F",ruleset,height/4, radians(40));
        return lSystem;
    }
    //*/

    /*
    private LSystem get3_2_a(){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "F[+F]F[−F]F");
        ruleset.put("G", "G");
        ruleset.put("+", "+");
        ruleset.put("-", "-");
        ruleset.put("[", "[");
        ruleset.put("]", "]");
        LSystem lSystem = new LSystem("F",ruleset,height/4, radians(25));
        return lSystem;
    }
    */

    public static LSystemsTreesApp getApp(){
        return app;
    }
}
