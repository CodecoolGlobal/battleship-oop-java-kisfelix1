package com.codecool.battleship;

import com.codecool.battleship.core.Board;
import com.codecool.battleship.core.BoardFactory;


public class Game {
    private Board board;

    public Game() {
        setup();
        gameCycle();
    }

    private void setup() {
        BoardFactory boardFactory = new BoardFactory(board);

    }

    private void gameCycle() {
        while(!checkWin()){

        }
    }

    private boolean checkWin() {
        return false;
    }


}