package ru.dandam.seabattle;

public class Point {
    int x;
    int y;


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
}
