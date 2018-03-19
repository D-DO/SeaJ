package ru.dandam.seabattle;

import java.util.Random;

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

//    static Point getRandomPoint(int sizeSheep, boolean horizontal) {
//        Point tempPoint = new Point();
//        Random random = new Random();
//        if (sizeSheep > 1) {
//            if (horizontal) {
//                tempPoint.x = random.nextInt(9 - sizeSheep);
//                tempPoint.y = random.nextInt(9);
//            } else {
//                tempPoint.x = random.nextInt(9);
//                tempPoint.y = random.nextInt(9 - sizeSheep);
//            }
//        } else {
//            tempPoint.x = random.nextInt(9);
//            tempPoint.y = random.nextInt(9);
//        }
//        return tempPoint;
//    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
