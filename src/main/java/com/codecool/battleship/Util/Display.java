package com.codecool.battleship.Util;

public class Display {
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
}
