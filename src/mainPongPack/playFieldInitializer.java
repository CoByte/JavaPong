package mainPongPack;

import aiPackage.TestAI;
import processing.core.PApplet;
import aiPackage.TestAI2;

public class playFieldInitializer {

    Paddle paddle1;
    Paddle paddle2;
    Ball ball;

    PApplet sketch;

    AIInterface playerOne;
    AIInterface playerTwo;

    int leftScore;
    int rightScore;

    playFieldInitializer(PApplet sketch) {

        this.sketch = sketch;

        this.playerOne = new TestAI();
        this.playerTwo = new TestAI2();

        this.ball = new Ball(this.sketch, 2);
        this.paddle1 = new Paddle(this.sketch, true);
        this.paddle2 = new Paddle(this.sketch, false);

        this.leftScore = 0;
        this.rightScore = 0;

    }

    public void runGame() {

        paddle1.move(playerOne.getPaddleDir(ball.getPos(), paddle1.getY()));
        paddle2.move(playerTwo.getPaddleDir(ball.getPos(), paddle2.getY()));

        ball.drawBall(paddle1, paddle2);

        leftScore = ball.isLeftDead();
        rightScore = ball.isRightDead();
    }

    public boolean getGameState() { return ball.isAlive(); }
    public int getRightScore() { return rightScore; }
    public int getLeftScore() { return leftScore; }
}
