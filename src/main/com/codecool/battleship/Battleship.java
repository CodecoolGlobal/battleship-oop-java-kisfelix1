package com.codecool.battleship;

import com.codecool.battleship.utility.Display;
import com.codecool.battleship.utility.Input;

public class Battleship {
    public static void main(String[] args) {
        Input input = new Input();
        Display display = new Display();
        boolean quit = false;
        while (!quit) {
            display.printMainMenu();
            String choice = input.askUserInput();
            startMenuOption(choice);
        }
    }

    private static void startMenuOption(String choice) {
        if (choice.equals("3")) {
            System.exit(0);
        }
        Game game = new Game(choice);
        game.gameCycle();
    }
}