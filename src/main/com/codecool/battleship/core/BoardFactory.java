package com.codecool.battleship.core;

import com.codecool.battleship.utility.Display;
import com.codecool.battleship.utility.Input;

import java.util.Random;

public class BoardFactory {
    private static Random rand = new Random();
    private static final int MAP_SIZE = 10;
    private Board board;
    private Player player;

    public BoardFactory(Player player) {
        board = new Board(MAP_SIZE);
        this.player = player;
        this.player.setBoard(board);
        if(player.getName().equals("AI"))
        {
            randomPlacement();
        }
        else{
            manualPlacement();
        }
    }

    public void randomPlacement() {
        for (ShipType type : ShipType.values()) {
            tryRandomPlaceShip(type, "horizontal");
        }
    }

    public void manualPlacement() {
        for (ShipType type : ShipType.values()) {
            tryManualPlacement(type);
        }
    }

    private void tryManualPlacement(ShipType type) {
        String direction = "horizontal";
        Display display = new Display();
        display.printBoard(board);
        Input input = new Input();
        String move = input.askPlacementCoordinate(type);
        int[] shipCoordinates = input.convertStringToMove(move);
        Ship ship = new Ship(type);
        if (board.isPlacementOk(shipCoordinates[0], shipCoordinates[1], ship, direction)) {
            placeShip(shipCoordinates[0], shipCoordinates[1], ship, direction);
        }
        else{
            tryManualPlacement(type);
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
                Square targetSquare = board.getSquare(fromXCoordinate, column);
                ship.addPosition(targetSquare);
            }
        }
        else {
            int toXCoordinate = fromXCoordinate + shipSize;
            for (int row = fromXCoordinate; row < toXCoordinate; row++) {
                Square targetSquare = board.getSquare(row, fromYCoordinate);
                ship.addPosition(targetSquare);
            }
        }
        player.addShip(ship);
    }
}