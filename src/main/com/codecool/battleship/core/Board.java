package com.codecool.battleship.core;

public class Board {

    private Square[][] ocean;

    public Board(int mapSize) {
        ocean = new Square[mapSize][mapSize];
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
        return ocean[x][y] == null;
    }

//    public boolean isPlacementOk(int x, int y, Ship ship, String direction) {
//        int size = ship.shipType.size;
//        return isInsideBoard(x, y, size, direction) && isEmpty(x, y);
//    }
}