package ru.dandam.seabattle.Model;

public class Point {
    private int x;
    private int y;


    public Point() {

    }

    public Point(int xx, int yy) {
        x = xx;
        if (x < 0) {
            x = 0;
        }
        if (x > 9) {
            x = 9;
        }

        this.y = yy;
        if (y < 0) {
            y = 0;
        }
        if (y > 9) {
            y = 9;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
