package ru.dandam.seabattle.Model;

import ru.dandam.seabattle.Controller.GameController;

import java.util.Random;

public class Field {
    private String name;
    private int size;
    Sheep[][] sheep;
    public Cell[][] cells = new Cell[10][10];
    Point tempPositionTopLeftOfSheep = new Point();
    Point[] tempPointsOfSheep;//// массив координат ячеек корабля

    public Field() {
        initCells();
    }

    public void initCells() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }

//        for (int i = 0; i < 25; i++) {
//            for (int j = 0; j < 25; j++) {
//                for (int k = 0; k < ; k++) {
//
//                }
//
//            }
//
//        }

//        for (int i = 0; i < sheep.length; i++) {
//            Sheep[] sheep1 = sheep[i];
//            for (int j = 0; j < sheep1.length; j++) {
//                Sheep sheep2 = sheep1[j];
//
//            }
//
//        }

    }

    public void initCellsVisible(boolean visible) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j].setVisible(visible);
            }
        }
    }

    public void getRandomPoint(int sizeSheep, boolean horizontal) {
        Random random = new Random();

        if (horizontal) {
            tempPositionTopLeftOfSheep.setY(random.nextInt(10 - sizeSheep + 1));
            tempPositionTopLeftOfSheep.setX(random.nextInt(10));
        } else {
            tempPositionTopLeftOfSheep.setX(random.nextInt(10));
            tempPositionTopLeftOfSheep.setX(random.nextInt(10 - sizeSheep + 1));
        }
//        if (sizeSheep == 4) {
//            tempPositionTopLeftOfSheep.getY() = 0;
//            tempPositionTopLeftOfSheep.getX() = 0;
//        }
    }

    public void initPoints(int sizeSheep, Point positionTopLeft, boolean horizontal) {
        tempPointsOfSheep = new Point[sizeSheep];
        if (horizontal) {
            tempPointsOfSheep[0] = new Point(positionTopLeft.getX(), positionTopLeft.getY()); // массив координат ячеек корабля
            for (int i = 1; i < sizeSheep; i++) {
                tempPointsOfSheep[i] = new Point(positionTopLeft.getX(), positionTopLeft.getY() + i);
            }
        } else {
            tempPointsOfSheep[0] = new Point(positionTopLeft.getX(), positionTopLeft.getY());
            for (int i = 1; i < sizeSheep; i++) {
                tempPointsOfSheep[i] = new Point(positionTopLeft.getX() + i, positionTopLeft.getY());
            }
        }
    }

    public void initSheep() {
        sheep = new Sheep[4][];
        sheep[0] = new Sheep[1];
        sheep[1] = new Sheep[2];
        sheep[2] = new Sheep[3];
        sheep[3] = new Sheep[4];
        Random random = new Random();
        boolean horizontal;

        for (int i = 0; i < sheep.length; i++) {
            Sheep[] column = sheep[i];
            for (int j = 0; j < column.length; j++) {

                do {
                    horizontal = random.nextBoolean();
                    getRandomPoint(4 - i, horizontal);
                    initPoints(4 - i, tempPositionTopLeftOfSheep, horizontal);

                } while (sheepIntersection(tempPointsOfSheep, 4 - i));

                column[j] = new Sheep(tempPositionTopLeftOfSheep, 4 - i, horizontal);


                for (int k = 0; k < column[j].maxNumbersCellsNearSheep; k++) {
                    // if (cellsUser1[column[j].points[k].getX()][column[j].points[k].getY()].getSheep() == null) {
                    cells[column[j].nearPoints[k].getX()][column[j].nearPoints[k].getY()].setNearSheep(true);
//                    System.out.println(column[j].nearPoints[k].getX() + " " + column[j].nearPoints[k].getY() + " #");
                    //   }

                }
                for (int k = 0; k < column[j].getSize(); k++) {
                    cells[column[j].points[k].getX()][column[j].points[k].getY()].setSheep(column[j]);
                }
            }
        }

    }

    public void isKilledSheep() {
        for (int i = 0; i < sheep.length; i++) {
            Sheep[] column = sheep[i];
            for (int j = 0; j < column.length; j++) {

                for (int k = 0; k < column[j].maxNumbersCellsNearSheep; k++) {

                    if (column[j].isKilled()) {
                        cells[column[j].nearPoints[k].getX()][column[j].nearPoints[k].getY()].yesShoot();
                    }

                }
            }
        }
    }

    public boolean isOver() {
        int count = 0;
        for (int i = 0; i < sheep.length; i++) {
            Sheep[] column = sheep[i];
            for (int j = 0; j < column.length; j++) {
                if (column[j].isKilled()) {
                    count++;
                }
            }
        }
        if (count == 10) {
            return true;
        } else {
            return false;
        }

    }

    public boolean sheepIntersection(Point[] points, int sizeSheep) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < sizeSheep; k++) {
                    if ((points[k].getX() == cells[i][j].getPositionHoriz()) &&
                            (points[k].getY() == cells[i][j].getPositionVert()) &&
                            cells[i][j].isNearSheep()
                            ) {
                        System.out.println("Пересекает");
                        return true;
                    }
                }
            }
        }
        System.out.println("Ok");
        return false;
    }


    public void printCells() {
        printHeadNumber(1);
        System.out.println();
        for (int i = 0; i < 10; i++) {


            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.print("   " + cells[i][j].getAlphabeticX() + " ");

                }

                System.out.print(cells[i][j].getShowingCell());
                GameController.setShowInWindow(i, j, cells[i][j].getShowingCell());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printCells1() {
        printHeadNumber(1);
        System.out.println();
        for (int i = 0; i < 10; i++) {


            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.print("   " + cells[i][j].getAlphabeticX() + " ");

                }

                System.out.print(cells[i][j].getShowingCell());
                GameController.setShowInWindow1(i, j, cells[i][j].getShowingCell());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printHeadNumber(int p) {
        if (p == 1) {

            System.out.print("             Ваше поле:                         Поле соперника:");
            System.out.println();
            System.out.println();
        }
        System.out.print("     ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i + " ");
        }
        if (p == 2) {
            System.out.println();
        }
    }


}
