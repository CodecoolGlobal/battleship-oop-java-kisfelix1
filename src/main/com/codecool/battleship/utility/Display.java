package com.codecool.battleship.utility;

import com.codecool.battleship.core.Board;

public class Display {
    private final static int ASCII_CHARACTER_A = 65;

    public void println(String print) {
        System.out.println(print);
    }

    public void print(String print) {
        System.out.print(print);
    }

    public void printMainMenu() {
        println("[1]Start new game\n" +
                "[2]Start new game with different game mode\n" +
                "[3]Exit");
    }

    public void printBoard(Board board) {
        int boardSize = board.getOcean().length;
        print("  ");
        for (int i = 1; i <= boardSize; i++){
            print(i + "  ");
        }
        println("");
        for (int i = 0; i < boardSize; i++){
            print((char)(i + ASCII_CHARACTER_A) + "  ");
            for (int j = 0; j < boardSize; j++){
                switch (board.getOcean()[i][j].getStatus()) {
                    case SHIP:
                        print("S  ");
                        break;
                    case MISSED:
                        print("M  ");
                        break;
                    case EMPTY:
                        print(".  ");
                        break;
                    case HIT:
                        print("H  ");
                        break;
                }
            }
            println("");
        }
    }

    public void printWinner(int player) {
        println("Player " + player + " has won the game!");
    }
}
