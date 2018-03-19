package ru.dandam.seabattle;

public class Field {
    private String name;
    private int size;


    Cell[][] cellsUser1 = new Cell[10][10];
    Cell[][] cellsUser2 = new Cell[10][10];


//        for (int i = 0; i < cells.length; i++) {
//        Cell[] column = cells[i];
//        for (int j = 0; j < column.length; j++) {
//            column[j] = new Cell();
//            column[j].isShoot = true;
//        }
//    }

    public void initCellsUser1() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cellsUser1[i][j] = new Cell(i, j);
            }
        }
    }

    public void printCellsUser1() {
        printHeadNumber(1);
        System.out.println();
        for (int i = 0; i < 10; i++) {


            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.print("   " + cellsUser1[i][j].getC() + " ");
                }

                System.out.print(cellsUser1[i][j].getS());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void initCellsUser2() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cellsUser2[i][j] = new Cell(i, j);
            }
        }
    }

    public void printCellsUser2() {
        printHeadNumber(1);
        System.out.println();
        for (int i = 0; i < 10; i++) {


            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.print("   " + cellsUser2[i][j].getC() + " ");
                }

                System.out.print(cellsUser2[i][j].getS());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printCellsUser1User2() {



        printHeadNumber(1);
        printHeadNumber(2);


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j == 0) {
                    System.out.print("   " + cellsUser1[i][j].getC() + " ");
                }
                if (j == 10) {
                    System.out.print("    " + cellsUser2[i][j - 10].getC() + " ");
                }
                if (j < 10) {
                    System.out.print(cellsUser1[i][j].getS());
                } else {
                    System.out.print(cellsUser2[i][j - 10].getS());
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
