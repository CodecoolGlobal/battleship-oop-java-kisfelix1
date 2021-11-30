package com.codecool.battleship.core;

public class Board {

    private Square[][] ocean;

    public Board(int mapSize) {
        ocean = new Square[mapSize][mapSize];
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean.length; j++) {
                ocean[i][j] = new Square(i, j);
            }
        }
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public void setOcean(int x, int y, Square value) {
        ocean[x][y] = value;
    }

    private boolean isInsideBoard(int x, int y, int size, String direction) {
        int xEnd = direction.equals("vertical") ? x + size : x;
        int yEnd = direction.equals("horizontal") ? y + size : y;
        return x >= 0 &&
                y >= 0 &&
                xEnd < ocean.length &&
                yEnd < ocean.length;
    }

    private boolean isEmpty(int x, int y) {
        return ocean[x][y].getStatus() == Square.SquareStatus.EMPTY;
    }

    public boolean isPlacementOk(int x, int y, Ship ship, String direction) {
        int size = ship.type.shipSize;
        return isInsideBoard(x, y, size, direction) && isEmpty(x, y);
    }
}