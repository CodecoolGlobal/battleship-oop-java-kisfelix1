package com.codecool.battleship.core;

import java.util.Random;

public class BoardFactory {
    private static Random rand = new Random();
    private static final int MAP_SIZE = 10;
    private Board board;
    private Player player;

    public BoardFactory(Player player) {
        board = new Board(MAP_SIZE);
        this.player = player;
        this.player.board = board;
        randomPlacement();
    }

    public void randomPlacement() {
        for (Ship.ShipType type : Ship.ShipType.values()) {
            tryRandomPlaceShip(type, "horizontal");
        }
    }

    private void tryRandomPlaceShip(Ship.ShipType type, String direction) {
        int x = rand.nextInt(board.getOcean().length - type.shipSize);
        int y = rand.nextInt(board.getOcean().length - type.shipSize);
        Ship ship = new Ship(type);
        if (board.isPlacementOk(x, y, ship, direction)) {
            placeShip(x, y, ship, direction);
        }
        else{
            tryRandomPlaceShip(type, direction);
        }
    }

    private void placeShip(int x, int y, Ship ship, String direction) {
        if (direction.equals("horizontal")) {
            for (int i = y; i < y + ship.type.shipSize; i++) {
                ship.addPosition(board.getOcean()[x][i]);
            }
        }
        else {
            for (int i = y; i < y + ship.type.shipSize; i++) {
                ship.addPosition(board.getOcean()[i][y]);
            }
        }
        player.addShip(ship);
    }

    public void manualPlacement(Ship.ShipType type) {

    }
}