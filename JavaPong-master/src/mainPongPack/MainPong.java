package mainPongPack;

import processing.core.PApplet;

public class MainPong extends PApplet {

    playFieldInitializer gameField;

    int leftScore;
    int rightScore;

    public void settings() {
        size(1280, 720);

        gameField = new playFieldInitializer(this);

        leftScore = 0;
        rightScore = 0;
    }

    public void setup() {

        frameRate(60 * 5);
    }

    public void draw() {
        background(255);

        gameField.runGame();

        textSize(40);
        textAlign(CENTER);
        text(rightScore + " - " + leftScore,640,353);

        if(!gameField.getGameState()) {

            leftScore += gameField.getLeftScore();
            rightScore += gameField.getRightScore();

            gameField = new playFieldInitializer(this);
        }
    }

    public static void main(String[] args) {
        String[] pArgs =  {"MainPong"};
        MainPong mp = new MainPong();
        PApplet.runSketch(pArgs, mp);

    }
}
