package ru.dandam.seabattle.Controller;

import ru.dandam.seabattle.Model.Point;
import ru.dandam.seabattle.Model.Game;
import ru.dandam.seabattle.Model.User;
import ru.dandam.seabattle.View.GameWindow;

import java.awt.*;

public class GameController {


    public static void doShootFromWindow(Point point) {
        Game.user2.field.cells[point.x][point.y].yesShoot();
        Game.user2.setShoot();
    }


    public static void setShowInWindow(int i, int j, String s) {

        if (s == " + ") {
            GameWindow.buttons[i][j].setBackground(Color.GRAY);

        }
        if (s == " X ") {
            GameWindow.buttons[i][j].setBackground(Color.red);

        }
        if (s == " ~ ") {
            GameWindow.buttons[i][j].setBackground(Color.white);
        }
        if (s == " O ") {
            GameWindow.buttons[i][j].setBackground(Color.GREEN);

        }

        GameWindow.buttons[i][j].setText("");

    }

    public static void setShowInWindow1(int i, int j, String s) {



        if (s == " + ") {
            GameWindow.buttons1[i][j].setBackground(Color.GRAY);

        }
        if (s == " X ") {
            GameWindow.buttons1[i][j].setBackground(Color.red);

        }
        if (s == " ~ ") {
            GameWindow.buttons1[i][j].setBackground(Color.white);
        }
        if (s == " O ") {
            GameWindow.buttons1[i][j].setBackground(Color.BLUE);
        }

        GameWindow.buttons1[i][j].setText("");
    }

    public static void showWinInWindow(String s) {

        GameWindow.jTextFieldWin.setText(s);
        GameWindow.jPanelBottom.add(GameWindow.jTextFieldWin);
    }
}
