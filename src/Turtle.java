public class Turtle {
    private float lineLength, theta;

    public Turtle(float lineLength, float theta) {
        this.lineLength = lineLength;
        this.theta = theta;
    }

    public void render(char c, int numGenerations) {
        float length = (float) (lineLength * Math.pow(2, -numGenerations));
        LSystemsTreesApp app = LSystemsTreesApp.getApp();
        app.stroke(0, 175);
        if (c == 'F') {
            app.line(0,0,length,0);
            app.translate(length, 0);
        } else if (c == 'G') {
            app.translate(length, 0);
        } else if (c == '+') {
            app.rotate(theta);
        } else if (c == '-') {
            app.rotate(-theta);
        } else if (c == '[') {
            app.pushMatrix();
        } else if (c == ']') {
            app.popMatrix();
        }
    }
}
