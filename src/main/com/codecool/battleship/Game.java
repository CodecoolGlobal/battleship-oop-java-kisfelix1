package com.codecool.battleship;

import com.codecool.battleship.core.Board;
import com.codecool.battleship.core.BoardFactory;
import com.codecool.battleship.utility.*;


public class Game {
    private static final Display display = new Display();
    private static final Input input = new Input();
    private Board board;

    public Game() {
        setup();
        gameCycle();
    }

    private void setup() {
        BoardFactory boardFactory = new BoardFactory(board);

    }

    private void gameCycle() {
        while (!checkWin()) {
            display.printBoard(10);
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