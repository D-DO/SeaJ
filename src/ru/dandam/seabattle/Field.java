package ru.dandam.seabattle;

import java.util.Random;

public class Field {
    private String name;
    private int size;
    User user1 = new User();
    User user2 = new User();

    public Field() {
        InitCells();
    }

    //
    //  Cell[][] cellsUser1 = new Cell[10][10];
    //Cell[][] cellsUser2 = new Cell[10][10];

    public void InitCells() {
        user1.cells = new Cell[10][10];
        user2.cells = new Cell[10][10];

    }

    public void InitSheep(User user) {
        user.sheep = new Sheep[4][];
        user.sheep[0] = new Sheep[1];
        user.sheep[1] = new Sheep[2];
        user.sheep[2] = new Sheep[3];
        user.sheep[3] = new Sheep[4];
        Random random = new Random();
        boolean horizontal;

        for (int i = 0; i < user.sheep.length; i++) {
            Sheep[] column = user.sheep[i];
            for (int j = 0; j < column.length; j++) {

                do {
                    horizontal = random.nextBoolean();
                    column[j] = new Sheep(Point.getRandomPoint(4 - i, horizontal), 4 - i, horizontal);
                } while (sheepIntersection(column[j], user));

                for (int k = 0; k < column[j].getSize(); k++) {
                    user.cells[column[j].points[k].x][column[j].points[k].y].setSheep(column[j]);
                }
                for (int k = 0; k < column[j].numbersCellsNearSheep; k++) {
                    // if (cellsUser1[column[j].points[k].x][column[j].points[k].y].getSheep() == null) {
                    user.cells[column[j].nearPoints[k].x][column[j].nearPoints[k].y].setNearSheep(true);
                    //   }

                }
            }
        }

    }

    public boolean sheepIntersection(Sheep sheep, User user) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < sheep.getSize(); k++) {
                    if ((sheep.points[k].x == user.cells[i][j].getPositionHoriz()) &&
                            (sheep.points[k].y == user.cells[i][j].getPositionVert()) &&
                            user.cells[i][j].isNearSheep()
                            ) {
                        return true;

                    }
                }

            }
        }
        return false;
    }


    //        for (int i = 0; i < cells.length; i++) {
//        Cell[] column = cells[i];
//        for (int j = 0; j < column.length; j++) {
//            column[j] = new Cell();
//            column[j].isShoot = true;
//        }
//    }

    public void initCellsUser(User user) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                user.cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void printCellsUser(User user) {
        printHeadNumber(1);
        System.out.println();
        for (int i = 0; i < 10; i++) {


            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.print("   " + user.cells[i][j].getAlphabeticDes() + " ");
                }

                System.out.print(user.cells[i][j].getShowingCell());
            }
            System.out.println();
        }
        System.out.println();
    }

//    public void initCellsUser2() {
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                cellsUser2[i][j] = new Cell(i, j);
//            }
//        }
//    }

//    public void printCellsUser2() {
//        printHeadNumber(1);
//        System.out.println();
//        for (int i = 0; i < 10; i++) {
//
//
//            for (int j = 0; j < 10; j++) {
//                if (j == 0) {
//                    System.out.print("   " + cellsUser2[i][j].getAlphabeticDes() + " ");
//                }
//
//                System.out.print(cellsUser2[i][j].getShowingCell());
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    public void printCellsUser1User2() {


        printHeadNumber(1);
        printHeadNumber(2);


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j == 0) {
                    System.out.print("   " + user1.cells[i][j].getAlphabeticDes() + " ");
                }
                if (j == 10) {
                    System.out.print("    " + user2.cells[i][j - 10].getAlphabeticDes() + " ");
                }
                if (j < 10) {
                    System.out.print(user1.cells[i][j].getShowingCell());
                } else {
                    System.out.print(user2.cells[i][j - 10].getShowingCell());
                }
            }
            System.out.println();
        }
    }

    private void printHeadNumber(int p) {
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
