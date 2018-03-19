package ru.dandam.seabattle.Model;

public class Sheep {
    private Point positionTopLeft;
    private Point positionBottomRight;
    Point[] points; //// массив координат ячеек корабля
    Point[] nearPoints; //// массив координат ячеек вокруг корабля
    int maxNumbersCellsNearSheep;
    private int size;
    private int shoots;
    private boolean isHorizontal = true;
    private boolean isKilled = false;



    public Point[] getPoints() {
        return points;
    }

    public Sheep(Point positionTopLeft, int size, boolean isHorizontal) {
        this.positionTopLeft = positionTopLeft;
        this.size = size;
        this.isHorizontal = isHorizontal;
        isKilled = false;
        shoots = 0;
        positionBottomRight = getPositionBottomRightFromSise();
        initPoints(size);
        maxNumbersCellsNearSheep = size * 3 + 6;
        getCellsNearSheep();
    }

    public void initPoints(int size) {
        points = new Point[size];
        if (isHorizontal) {
            points[0] = new Point(positionTopLeft.x, positionTopLeft.y); // массив координат ячеек корабля
            for (int i = 1; i < size; i++) {
                points[i] = new Point(positionTopLeft.x, positionTopLeft.y + i);
            }
            printS();
        } else {
            points[0] = new Point(positionTopLeft.x, positionTopLeft.y);
            for (int i = 1; i < size; i++) {
                points[i] = new Point(positionTopLeft.x + i, positionTopLeft.y);
            }
            printS();
        }
    }

    public Point getPositionBottomRightFromSise() {
        Point tempPoint = new Point();

        points = new Point[size];
        if (isHorizontal) {
            tempPoint.x = positionTopLeft.x;
            tempPoint.y = positionTopLeft.y + size;
        } else {
            tempPoint.y = positionTopLeft.y;
            tempPoint.x = positionTopLeft.x + size;
        }
        return tempPoint;


    }


    private void getCellsNearSheep() {

        nearPoints = new Point[maxNumbersCellsNearSheep];
        if (isHorizontal()) {

            for (int i = 0; i < size; i++) {
                nearPoints[i] = new Point(points[i].x - 1, points[i].y);
            }
            for (int i = 0; i < size; i++) {
                nearPoints[i + size] = new Point(points[i].x, points[i].y);
            }
            for (int i = 0; i < size; i++) {
                nearPoints[i + size * 2] = new Point(points[i].x + 1, points[i].y);
            }
            for (int i = 0; i < 3; i++) {
                nearPoints[i + size * 3] = new Point(points[0].x + i - 1, points[0].y - 1);
            }
            for (int i = 0; i < 3; i++) {
                nearPoints[i + size * 3 + 3] = new Point(points[size - 1].x + i - 1, points[size - 1].y + 1);
            }
        } else {
            for (int i = 0; i < size; i++) {
                nearPoints[i] = new Point(points[i].x, points[i].y - 1);
            }
            for (int i = 0; i < size; i++) {
                nearPoints[i + size] = new Point(points[i].x, points[i].y);
            }
            for (int i = 0; i < size; i++) {
                nearPoints[i + size * 2] = new Point(points[i].x, points[i].y + 1);
            }
            for (int i = 0; i < 3; i++) {
                nearPoints[i + size * 3] = new Point(points[0].x - 1, points[0].y + i - 1);
            }
            for (int i = 0; i < 3; i++) {
                nearPoints[i + size * 3 + 3] = new Point(points[size - 1].x + 1, points[size - 1].y + i - 1);
            }
        }
        for (int i = 0; i < maxNumbersCellsNearSheep; i++) {
            System.out.println(nearPoints[i]);
        }
    }


    private void printS() {
        for (int i = 0; i < size; i++) {
            System.out.print(points[i] + "   ");
        }
        System.out.println();
        System.out.println();
    }


    public Point getPositionTopLeft() {
        return positionTopLeft;
    }

    public void setPositionTopLeft(Point positionTopLeft) {
        this.positionTopLeft = positionTopLeft;
    }

    public Point getPositionBottomRight() {
        return positionBottomRight;
    }

    public void setPositionBottomRight(Point positionBottomRight) {
        this.positionBottomRight = positionBottomRight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public int getSoots() {
        return shoots;
    }

    public void setSoots(int soots) {
        this.shoots = soots;

    }

    public void incSoots() {
        shoots = shoots + 1;
        if (shoots == size) {
            setKilled(true);
        }
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;

    }

    public int getNumbersCellsNearSheep() {
        return maxNumbersCellsNearSheep;
    }

    public void setNumbersCellsNearSheep(int numbersCellsNearSheep) {
        this.maxNumbersCellsNearSheep = numbersCellsNearSheep;
    }
}
