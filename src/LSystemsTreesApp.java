import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class LSystemsTreesApp extends PApplet {
    //order of methods 1) main 2) constructor 3)processing methods //getapp at bottom
    public static LSystemsTreesApp app;
    private int regenerations;
    private ArrayList<LSystem> lSystems;

    public static void main(String[] args) {
        PApplet.main("LSystemsTreesApp");
    }

    public LSystemsTreesApp() {
        app = this;
        lSystems = new ArrayList<LSystem>();
        regenerations = 0;
    }

    public void settings() {
        size(1000, 500);
    }

    public void setup(){
        this.lSystems.add(get3_2_a(height/9, color(random(100,255), random(100,255), random(100,255))));
        this.lSystems.add(get3_2_b(height/8, color(random(100,255), random(100,255), random(100,255))));
        this.lSystems.add(get3_2_c(height/7, color(random(100,255), random(100,255), random(100,255))));
        this.lSystems.add(get3_2_d(height/6, color(random(100,255), random(100,255), random(100,255))));
        this.lSystems.add(get3_2_e(height/5, color(random(100,255), random(100,255), random(100,255))));
        this.lSystems.add(get3_2_d(height/4, color(random(100,255), random(100,255), random(100,255))));
        this.lSystems.add(get3_2_b(height/3, color(random(100,255), random(100,255), random(100,255))));
    }

    public void draw(){
        background(0);
        fill(color(random(100,255),random(100,255),random(100,255)));
        ellipse(width/4,height/3,200,200);
        for(int i = 0; i < lSystems.size(); i++){
            pushMatrix();
            translate(i*width/lSystems.size()+ random(25,50), height);
            rotate(-PI / 2);
            lSystems.get(i).render();
            popMatrix();
        }
        noLoop();
    }

    public void keyPressed(){
        save("trees.jpeg");
        //System.out.println("SAVED");
    }

    public void mouseClicked(){
        for(LSystem lSystem:lSystems){
            lSystem.generateNewSentence();
        }
        regenerations++;
        redraw();
    }

    private LSystem get3_2_a(float trunkHeight, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "F[+F]F[−F]F");
        LSystem lSystem = new LSystem("F",ruleset,trunkHeight, radians(26),color);
        return lSystem;
    }

    private LSystem get3_2_b(float trunkHeight, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "FF");
        ruleset.put("X", "F-[[X]+X]+F[+FX]-X");
        LSystem lSystem = new LSystem("X",ruleset,trunkHeight, radians(23),color);
        return lSystem;
    }

    private LSystem get3_2_c(float trunkHeight, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("Y", "YFX[+Y][=Y]");
        ruleset.put("X", "X[-FFF][+FFF]FX");
        ruleset.put("F", "F");
        LSystem lSystem = new LSystem("Y",ruleset,trunkHeight, radians(26),color);
        return lSystem;
    }

    private LSystem get3_2_d(float trunkHeight, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "FF+[+F-F-F]-[-F+F+F]");
        LSystem lSystem = new LSystem("F",ruleset,trunkHeight, radians(23),color);
        return lSystem;
    }

    private LSystem get3_2_e(float trunkHeight, int color){
        HashMap<String, String> ruleset = new HashMap<String, String>();
        ruleset.put("F", "FF");
        ruleset.put("X", "F[+X]F[-X]+X");
        LSystem lSystem = new LSystem("X",ruleset,trunkHeight, radians(20),color);
        return lSystem;
    }

    public static LSystemsTreesApp getApp(){
        return app;
    }
}
