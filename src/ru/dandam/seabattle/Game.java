package ru.dandam.seabattle;


import java.util.Scanner;

public class Game {


    String userMessage;
    Field field;
    Scanner scanner = new Scanner(System.in);

    void start() {
        initField();
        field.InitSheep(field.user1);
        field.InitSheep(field.user2);

        field.printCellsUser(field.user1);
        System.out.println(" Разместить корабли автоматически? Д - да Н - нет ");
      //  userMessage = scanner.nextLine();
        System.out.println(userMessage);

        field.printCellsUser1User2();


        field.user1.cells[1][1].setShoot(true);

        System.out.println(" Введите координаты выстрела: ");
        //userMessage = scanner.nextLine();
        System.out.println(userMessage);

        field.printCellsUser1User2();

        System.out.println(Point.getRandomPoint(4, true));

    }

    private void initField() {
        field = new Field();

        field.initCellsUser(field.user1);
        field.initCellsUser(field.user2);

    }
}
