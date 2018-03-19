package ru.dandam.seabattle;

public class Sheep {
    private Point positionTopLeft;
    private Point positionBottomRight;
    Point[] points; //// массив координат ячеек корабля
    Point[] nearPoints; //// массив координат ячеек вокруг корабля
    int numbersCellsNearSheep;
    private int size;
    private int soots;
    private boolean isHorizontal = true;
    private boolean isKilled = false;

    // public Sheep() {
    // }

    public Point[] getPoints() {
        return points;
    }

    public Sheep(Point positionTopLeft, int size, boolean isHorizontal) {
        this.positionTopLeft = positionTopLeft;
        this.size = size;
        this.isHorizontal = isHorizontal;
        isKilled = false;
        soots = 0;
        positionBottomRight = getPositionBottomRightFromSise();
        numbersCellsNearSheep = size * 3 + 6;
        getCellsNearSheep();
    }

    private void getCellsNearSheep() {
//
        numbersCellsNearSheep = size * 3 + 6;
        nearPoints = new Point[numbersCellsNearSheep];
        if (isHorizontal()) {

            for (int i = 0; i < size; i++) {
                nearPoints[i] = new Point(points[i].x - 1, points[i].y);
            }
            for (int i = 0; i < size; i++) {
                nearPoints[i + size] = new Point(points[i].x, points[i].y);
            }
            for (int i = 0; i < size; i++) {
                nearPoints[i + size*2] = new Point(points[i].x+1, points[i].y);
            }
            for (int i = 0; i < 3; i++) {
                nearPoints[i + size*3] = new Point(points[0].x+i-1, points[0].y-1);
            }
            for (int i = 0; i < 3; i++) {
                nearPoints[i + size*3+3] = new Point(points[size-1].x+i-1, points[size-1].y+1);
            }


        } else{

            for (int i = 0; i < size; i++) {
                nearPoints[i] = new Point(points[i].x , points[i].y-1);
            }
            for (int i = 0; i < size; i++) {
                nearPoints[i + size] = new Point(points[i].x, points[i].y);
            }
            for (int i = 0; i < size; i++) {
                nearPoints[i + size*2] = new Point(points[i].x, points[i].y+1);
            }
            for (int i = 0; i < 3; i++) {
                nearPoints[i + size*3] = new Point(points[0].x-1, points[0].y+i-1);
            }
            for (int i = 0; i < 3; i++) {
                nearPoints[i + size*3+3] = new Point(points[size-1].x+1, points[size-1].y+i-1);
            }

        }

        for (int i = 0; i <numbersCellsNearSheep ; i++) {

            System.out.println(nearPoints[i]);

        }


    }

    public Point getPositionBottomRightFromSise() {
        Point tempPpoint = new Point();

        points = new Point[size];
        if (isHorizontal) {
            tempPpoint.x = positionTopLeft.x;
            tempPpoint.y = positionTopLeft.y + size;

            points[0] = new Point(positionTopLeft.x, positionTopLeft.y); // массив координат ячеек корабля
            for (int i = 1; i < size; i++) {
                points[i] = new Point(positionTopLeft.x, positionTopLeft.y + i);
            }

            printS();


        } else {
            tempPpoint.y = positionTopLeft.y;
            tempPpoint.x = positionTopLeft.x + size;

            points[0] = new Point(positionTopLeft.x, positionTopLeft.y);
            for (int i = 1; i < size; i++) {
                points[i] = new Point(positionTopLeft.x + i, positionTopLeft.y);
            }

            printS();

        }        return tempPpoint;


    }

    private void printS() {
        for (int i = 0; i < size; i++) {
            System.out.print(points[i] + "   ");
        }
        System.out.println();
    }


    public int getSoots() {
        return soots;
    }

    public void setSoots(int soots) {
        this.soots = soots;
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

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public int getNumbersCellsNearSheep() {
        return numbersCellsNearSheep;
    }

    public void setNumbersCellsNearSheep(int numbersCellsNearSheep) {
        this.numbersCellsNearSheep = numbersCellsNearSheep;
    }
}
