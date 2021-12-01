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
        switch (choice) {
            case "1":
                Game game = new Game();
                game.gameCycle();
                break;
            case "2":
                System.out.println("Other option");
                break;
            case "3":
                System.exit(0);
                break;
        }
    }
}