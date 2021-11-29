package com.codecool.battleship.Util;

public class Display {
    private final static int ASCII_CHARACTER_A = 65;

    public void println(String print) {
        System.out.println(print);
    }
    public void print(String print) {
        System.out.print(print);
    }
    public void printMainMenu() {
        println("[1]Start new game" +
                "[2]Start new game with different game mode" +
                "[3]Exit");
    }
    public void printBoard(int boardSize) {
        String finalBoard = "";
        String boardCordNumbers = "";
        String boardTopBottom = "";
        for (int row = 0; row < boardSize+1; row++) {   //Generates the top and bottom part of the board, according to
            if (row == 0) {                             //the board size
                boardCordNumbers += "    ";
                boardTopBottom += "  - ";
            } if (row == boardSize) {
                boardCordNumbers += " \n";
                boardTopBottom += "- \n";
            } else {
                boardCordNumbers += (row+1)+" ";
                boardTopBottom += "- ";
            }
        }
        finalBoard += boardCordNumbers + boardTopBottom;
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (col == 0) {
                    finalBoard += row == 0 ? (char)(ASCII_CHARACTER_A+row)+" | " : "|\n" + (char)(ASCII_CHARACTER_A+row)+" | ";
                }
                finalBoard += ". ";
                 if (row == boardSize - 1 && col == boardSize-1) {
                    finalBoard += "|";
                }
                // NEED BOARD(OCEAN)
            }
        }
        finalBoard += "\n"+boardTopBottom;
        System.out.println(finalBoard);
    }
}
