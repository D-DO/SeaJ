package ru.dandam.seabattle;


import java.util.Scanner;

public class Game {
    String userMessage;
    Field field;
    Scanner scanner = new Scanner(System.in);

    void start() {
        initField();

        field.printCellsUser1();
        System.out.println(" Разместить корабли автоматически? Д - да Н - нет ");
        userMessage = scanner.nextLine();
        System.out.println(userMessage);

        field.printCellsUser1User2();


        System.out.println(" Введите координаты выстрела: ");
        userMessage = scanner.nextLine();
        System.out.println(userMessage);


    }

    private void initField() {
        field = new Field();
        field.initCellsUser1();
        field.initCellsUser2();

    }
}
