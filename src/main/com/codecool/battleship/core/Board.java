package com.codecool.battleship.core;

public class Board {

    private Square[][] ocean;

    public Board(int mapSize) {
        ocean = new Square[mapSize][mapSize];
        for (int row = 0; row < ocean.length; row++) {
            for (int column = 0; column < ocean.length; column++) {
                ocean[row][column] = new Square(row, column);
            }
        }
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public Square getSquare(int x, int y) {
        return ocean[x][y];
    }

    public void setOceanSquare(int x, int y, Square value) {
        ocean[x][y] = value;
    }

    private boolean isPlacementInsideBoard(int x, int y, int size, String direction) {
        int xEnd = direction.equals("vertical") ? x + size : x;
        int yEnd = direction.equals("horizontal") ? y + size : y;
        return x >= 0 &&
                y >= 0 &&
                xEnd < ocean.length &&
                yEnd < ocean.length;
    }

    private boolean isPlacementEmpty(int x, int y, ShipType type, String direction) {
        if (direction.equals("horizontal")) {
            for (int i = y; i < y + type.shipSize; i++) {
                if (!ocean[x][i].getStatus().equals(SquareStatus.EMPTY)) {
                    return false;
                }
            }
        } else {
            for (int i = x; i < x + type.shipSize; i++) {
                if (!ocean[i][y].getStatus().equals(SquareStatus.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPlacementOk(int x, int y, Ship ship, String direction) {
        int size = ship.getType().shipSize;
        return isPlacementInsideBoard(x, y, size, direction) && isPlacementEmpty(x, y, ship.getType(), direction);
    }
}