package com.codecool.battleship;

import com.codecool.battleship.core.Board;
import com.codecool.battleship.core.BoardFactory;
import com.codecool.battleship.core.Player;
import com.codecool.battleship.utility.*;


public class Game {
    private static final Display display = new Display();
    private static final Input input = new Input();

    private Player player1;
    private Player player2;

    public Game() {
        setup();
        gameCycle();
    }

    private void setup() {
        player1 = new Player();
        System.out.println("aaa");
        player2 = new Player();
    }

    private void gameCycle() {
        while (!checkWin()) {
            //display.printBoard(10);
            playerShoot();
            //changeCurrentPlayer();

        }
    }

    private void playerShoot() {
        input.askAttackCoordinate(1);
    }

    private boolean checkWin() {
        return false;
    }


}