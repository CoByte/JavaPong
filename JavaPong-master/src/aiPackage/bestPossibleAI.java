package aiPackage;

import mainPongPack.AIInterface;
import processing.core.PVector;

public class bestPossibleAI implements AIInterface {

    private PVector previousCoords = new PVector(0,0);
    private PVector newCoords = new PVector();

    private PVector saveCoords = new PVector();

    int bounceNum;
    float slope, target;
    boolean yInvert;

    public int getPaddleDir(PVector ballPos, int paddlePos) {

        yInvert = false;

        newCoords.x = ballPos.x;
        newCoords.y = ballPos.y;

        saveCoords.x = ballPos.x;
        saveCoords.y = ballPos.y;

        if (newCoords.x > previousCoords.x) {

            previousCoords.x = newCoords.x;
            previousCoords.y = newCoords.y;

            return goToLocation(paddlePos, 360);
        }

        if (newCoords.y < previousCoords.y) {

            newCoords.y = 720 - newCoords.y;
            previousCoords.y = 720 - previousCoords.y;

            yInvert = true;
        }

        newCoords.x = 1280 - newCoords.x;
        previousCoords.x = 1280 - previousCoords.x;

        slope = (newCoords.y - previousCoords.y)/(newCoords.x - previousCoords.x);
        target = slope * (1280-previousCoords.x) + previousCoords.y;

        bounceNum = (int) target / 720;

        if (bounceNum % 2 == 0) {

            target = (target % 720);

        } else {

            target = 720 - (target % 720);
        }

        previousCoords.x = saveCoords.x;
        previousCoords.y = saveCoords.y;

        if(yInvert) {

            target = 720 - target;
        }

        return goToLocation(paddlePos, (int) target);
    }

    private int goToLocation(int paddlePos, int loc) {

        if (paddlePos/20 > loc/20) {

            return -1;
        } else if (paddlePos/20 < loc/20){

            return 1;
        } else {

            return 0;
        }
    }
}
