package aiPackage;

import mainPongPack.AIInterface;
import processing.core.PVector;

public class TestAI implements AIInterface {

    int paddleDir;

    public int getPaddleDir(PVector ballPos, int paddlePos) {

        paddleDir = Math.min(Math.max((int) (ballPos.y - paddlePos), -1), 1);

        return paddleDir;
    }
}
