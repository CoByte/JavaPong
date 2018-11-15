package aiPackage;

import mainPongPack.AIInterface;
import processing.core.PVector;

public class ChaseAI implements AIInterface {

    private int loopCount = 0;
    private PVector prevPos = new PVector(0, 0);
    private PVector tempBall = new PVector(0, 0);
    private PVector tempVel = new PVector(1, 0);
    private float tempSpeed;
    private int finalY;
    int direction;

    public int getPaddleDir(PVector ballPos, int paddlePos) {

        if (loopCount == 0) {
            prevPos.x = ballPos.x;
            prevPos.y = ballPos.y;
            loopCount = 1;
            finalY = 360;

        } else if (loopCount == 1) {
            if (ballPos.x > prevPos.x) {
                loopCount = 2;

                tempBall.x = ballPos.x;
                tempBall.y = ballPos.y;
                tempSpeed = ballPos.x - prevPos.x;
                tempVel.y = (ballPos.y-prevPos.y)/tempSpeed;

                while (tempBall.x < 1260) {
                    tempBall.add(tempVel.x * tempSpeed, tempVel.y * tempSpeed);

                    if (tempBall.y > 720) {
                        tempVel.y *= -1;
                        tempBall.y -= tempSpeed;

                        tempSpeed += 0.5;

                    } else if (tempBall.y < 0) {
                        tempVel.y *= -1;
                        tempBall.y += tempSpeed;

                        tempSpeed += 0.5;
                    }
                }

                finalY = (int) tempBall.y;
            } else {
                loopCount = 0;
            }
        } else if (loopCount == 2) {
            if (ballPos.x < prevPos.x) {
                loopCount = 0;
            }
            prevPos.x = ballPos.x;
        }

        if (paddlePos > finalY + 10 || paddlePos < finalY - 10) {
            direction = Math.min(Math.max((finalY - paddlePos), -1), 1);
        } else {
            direction = 0;
        }
        return direction;
    }
}
