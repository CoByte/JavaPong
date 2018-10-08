package mainPongPack;

import processing.core.PVector;

public interface AIInterface {

    int getPaddleDir(PVector ballPos, int paddlePos);

}
