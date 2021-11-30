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
        player = this.player;
    }

    public void randomPlacement() {
        for (Ship.ShipType type : Ship.ShipType.values()) {
            tryPlaceShip(type);
        }
    }

    private void tryPlaceShip(Ship.ShipType type) {
        int x = rand.nextInt(board.getOcean().length - type.shipSize);
        int y = rand.nextInt(board.getOcean().length - type.shipSize);
        Ship ship = new Ship(type);
        if (board.isPlacementOk(x, y, ship, "horizontal")) {
            placeShip(x, y, ship, "horizontal");
        } else {
            tryPlaceShip(type);
        }
    }

    private void placeShip(int x, int y, Ship ship, String direction) {
        if (direction.equals("horizontal")) {
            for (int i = x; i < x + ship.type.shipSize; i++) {
                ship.addPosition(board.getOcean()[i][y]);
                board.getOcean()[i][y].setStatus(Square.SquareStatus.SHIP);
            }
        }
        else {
            for (int i = y; i < y + ship.type.shipSize; i++) {
                ship.addPosition(board.getOcean()[x][i]);
                board.getOcean()[x][i].setStatus(Square.SquareStatus.SHIP);
            }
        }
        player.addShip(ship);
    }

    public void manualPlacement(Ship.ShipType type) {

    }
}