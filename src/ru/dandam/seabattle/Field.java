package ru.dandam.seabattle;

import java.util.Random;

public class Field {
    private String name;
    private int size;
    Sheep[][] sheep;
    Cell[][] cells = new Cell[10][10];


    public void InitSheep() {
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
                    column[j] = new Sheep(Point.getRandomPoint(4 - i, horizontal), 4 - i, horizontal);
                } while (sheepIntersection(column[j]));

                for (int k = 0; k < column[j].getSize(); k++) {
                    cells[column[j].points[k].x][column[j].points[k].y].setSheep(column[j]);
                }
                for (int k = 0; k < column[j].numbersCellsNearSheep; k++) {
                    // if (cellsUser1[column[j].points[k].x][column[j].points[k].y].getSheep() == null) {
                    cells[column[j].nearPoints[k].x][column[j].nearPoints[k].y].setNearSheep(true);
                    //   }

                }
            }
        }

    }

    public boolean sheepIntersection(Sheep sheep)   {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < sheep.getSize(); k++) {
                    if ((sheep.points[k].x == cells[i][j].getPositionHoriz()) &&
                            (sheep.points[k].y == cells[i][j].getPositionVert()) &&
                            cells[i][j].isNearSheep()
                            ) {
                        return true;

                    }
                }

            }
        }
        return false;
    }




    public void initCells() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void printCells( ) {
        printHeadNumber(1);
        System.out.println();
        for (int i = 0; i < 10; i++) {


            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.print("   " + cells[i][j].getAlphabeticDes() + " ");
                }

                System.out.print(cells[i][j].getShowingCell());
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
