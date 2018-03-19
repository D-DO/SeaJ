package ru.dandam.seabattle;



import ru.dandam.seabattle.Model.Game;
import ru.dandam.seabattle.View.GameWindow;

public class Main {
    public static void main(String[] args) {

        GameWindow gameWindow = new GameWindow();
        gameWindow.init();

        Game game = new Game();
        game.start();
    }
}
