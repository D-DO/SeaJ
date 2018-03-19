package ru.dandam.seabattle.Model;


import ru.dandam.seabattle.Controller.GameController;

import java.util.Scanner;

public class Game {
    boolean over = false;
    Scanner scanner = new Scanner(System.in);
    public static User user1 = new User();
    public static User user2 = new User();


    public void start() {

        user2.field.initCellsVisible(false);
        user2.setName("Игрок");
        user1.setName("Компьютер");

        user1.field.initSheep();
        user2.field.initSheep();


//        user1.field.printCells();
//        user2.field.printCells();

        System.out.println(" Разместить корабли автоматически? Д - да Н - нет ");
        //  userMessage = scanner.nextLine();
        System.out.println(user1.message);

        printCellsUser1User2();


//        while (!over) {
//
//            do {
//                System.out.println(" Введите координаты выстрела: ");
//                user2.setMessage(scanner.nextLine());
//            } while (user2.isShoot(user2.getMessage()));
//
//            user2.field.isKilledSheep();
//            printCellsUser1User2();
//            isOver();
//        }
//    }
        user1.field.printCells();
        user2.field.printCells1();
        for (int i = 0; i < 100; i++) {

            System.out.println(" Введите координаты выстрела: ");
            user2.isShootFromWindow();
            user2.field.isKilledSheep();

            user2.field.printCells1();

            user1.setRandomShoot();
            user1.field.isKilledSheep();
            user1.field.printCells();

            printCellsUser1User2();


            if (isOver()) {
                user1.field.printCells();
                user2.field.printCells1();

                break;
            }
        }

    }

    boolean isOver() {

        over = user1.field.isOver() || user2.field.isOver();

        if (user1.field.isOver()) {
            System.out.println("Выйграл " + user1.getName());
            GameController.showWinInWindow("Выйграл " + user1.getName());
        }
        if (user2.field.isOver()) {
            System.out.println("Выйграл " + user2.getName());
            GameController.showWinInWindow("Выйграл " + user2.getName());
        }

        return over;

    }

    public void printCellsUser1User2() {
        user1.field.printHeadNumber(1);
        user1.field.printHeadNumber(2);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j == 0) {
                    System.out.print("   " + user1.field.cells[i][j].getAlphabeticX() + " ");
                }
                if (j == 10) {
                    System.out.print("    " + user2.field.cells[i][j - 10].getAlphabeticX() + " ");
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
