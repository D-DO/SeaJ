package ru.dandam.seabattle;


import java.util.Scanner;

public class Game {


    String userMessage;
    Field field;
    Scanner scanner = new Scanner(System.in);
    User user1 = new User();
    User user2 = new User();

    void start() {



        user1.field.initCells();
        user2.field.initCells();

        user1.field.InitSheep();
        user2.field.InitSheep();



        user1.field.printCells();
        user2.field.printCells();

        System.out.println(" Разместить корабли автоматически? Д - да Н - нет ");
      //  userMessage = scanner.nextLine();
        System.out.println(userMessage);

        printCellsUser1User2();


        user1.field.cells[1][1].setShoot(true);

        System.out.println(" Введите координаты выстрела: ");
        //userMessage = scanner.nextLine();
        System.out.println(userMessage);

        printCellsUser1User2();

        System.out.println(Point.getRandomPoint(4, true));

    }





    public void printCellsUser1User2() {


        user1.field.printHeadNumber(1);
        user1.field.printHeadNumber(2);


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j == 0) {
                    System.out.print("   " + user1.field.cells[i][j].getAlphabeticDes() + " ");
                }
                if (j == 10) {
                    System.out.print("    " + user2.field.cells[i][j - 10].getAlphabeticDes() + " ");
                }
                if (j < 10) {
                    System.out.print(user1.field.cells[i][j].getShowingCell());
                } else {
                    System.out.print(user2.field.cells[i][j - 10].getShowingCell());
                }
            }
            System.out.println();
        }
    }





}
