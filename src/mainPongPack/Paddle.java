package mainPongPack;

import processing.core.PApplet;

public class Paddle {

    PApplet sketch;

    boolean side;
    int x;
    int y;

    Paddle(PApplet sketch, boolean side) {

        this.sketch = sketch;
        this.side = side;
        this.y = 0;

        if (this.side) {
            this.x = 20;
        } else {
            this.x = this.sketch.width - 20;
        }
    }

    void move(int dir) {

        y += dir * 5;

        sketch.rectMode(sketch.CENTER);
        sketch.rect(x, y, 20, 80);
    }

    int getY() {
        return y;
    }
}
