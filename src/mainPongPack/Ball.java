package mainPongPack;

import processing.core.PVector;
import processing.core.PApplet;

public class Ball {

    PApplet sketch;
    PVector pos;
    boolean alive;
    private PVector vel;
    private float speed;
    int left;
    int right;
    java.util.Random randBool;

    Ball(PApplet sketch, float speed) {
        this.randBool = new java.util.Random();

        this.speed = speed;

        this.sketch = sketch;

        this.pos = new PVector(sketch.width / 2, sketch.height / 2);
        this.vel = new PVector(this.speed * ( this.randBool.nextBoolean() ? 1 : -1 ), sketch.random(-1, 1));

        this.alive = true;
        this.left = 0;
        this.right = 0;
    }

    boolean collidesWith(Paddle p) {
        if (p.x - 15 < pos.x && p.x + 15 > pos.x && p.y - 45 < pos.y && p.y + 45 > pos.y) {
            return true;
        } else {
            return false;
        }
    }

    private void move(Paddle p1, Paddle p2) {
        pos.add(vel.x * speed, vel.y * speed);

        if (pos.y > sketch.height) {
            vel.y *= -1;
            pos.y -= speed;

            speed += 0.5;

        } else if (pos.y < 0) {
            vel.y *= -1;
            pos.y += speed;

            speed += 0.5;
        }

        if (collidesWith(p1)) {
            vel.x *= -1;
            vel.y = sketch.random(-1, 1);
            pos.x += speed;

            speed += 0.5;

        } else if (collidesWith(p2)) {
            vel.x *= -1;
            vel.y = sketch.random(-1, 1);
            pos.x -= speed;

            speed += 0.5;
        }

        if (pos.x > sketch.width) {
            speed = 0;
            alive = false;
            right = 1;
        }

        if (pos.x < 0) {
            speed = 0;
            alive = false;
            left = 1;
        }
    }

    public void drawBall(Paddle p1, Paddle p2) {
        move(p1 ,p2);
        sketch.noStroke();
        sketch.fill(255, 0, 0);
        sketch.ellipse(pos.x, pos.y, 10, 10);
    }

    public PVector getPos() {
        return pos;
    }
    public boolean isAlive() { return alive; }
    public int isLeftDead() { return left; }
    public int isRightDead() { return right; }
}
