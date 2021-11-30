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
        for (ShipType type : ShipType.values()) {
            tryRandomPlaceShip(type, "horizontal");
        }
    }

    private void tryRandomPlaceShip(ShipType type, String direction) {
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

    private void placeShip(int fromXCoordinate, int fromYCoordinate, Ship ship, String direction) {
        int shipSize = ship.getType().shipSize;
        if (direction.equals("horizontal")) {
            int toYCoordinate = fromYCoordinate + shipSize;
            for (int column = fromYCoordinate; column < toYCoordinate; column++) {
                ship.addPosition(board.getOcean()[fromXCoordinate][column]);
            }
        }
        else {
            int toXCoordinate = fromXCoordinate + shipSize;
            for (int row = fromXCoordinate; row < toXCoordinate; row++) {
                ship.addPosition(board.getOcean()[row][fromYCoordinate]);
            }
        }
        player.addShip(ship);
    }

    public void manualPlacement(ShipType type) {

    }
}