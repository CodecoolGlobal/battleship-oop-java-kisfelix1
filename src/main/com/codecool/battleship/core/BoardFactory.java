package com.codecool.battleship.core;

import java.util.Random;

public class BoardFactory {
    private static Random rand = new Random();
    private static final int MAP_SIZE = 10;
    private Board board;

    public BoardFactory(Board board) {
        this.board = board;
        this.board = new Board(MAP_SIZE);
    }

    public void randomPlacement() {
        for (Ship.ShipType type : Ship.ShipType.values()) {
            tryPlaceShip(type);
        }
    }

    private void tryPlaceShip(Ship.ShipType type) {
        int x = rand.nextInt(board.getOcean().length - type.shipSize);
        int y = rand.nextInt(board.getOcean().length - type.shipSize);
        //if(board.isPlacementOk(x, y, , "horizontal"))
    }

    public void manualPlacement(Ship.ShipType type) {

    }
}