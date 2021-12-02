package com.codecool.battleship.core;

import com.codecool.battleship.utility.Display;
import com.codecool.battleship.utility.Input;

import java.util.Random;

public class BoardFactory {
    private static final Random rand = new Random();
    private static final Input input = new Input();
    private static final Display display = new Display();
    private static final int MAP_SIZE = 10;
    private final Board board;
    private final Player player;

    public BoardFactory(Player player) {
        board = new Board(MAP_SIZE);
        this.player = player;
        this.player.setBoard(board);
        placeShips(player);
    }

    private void placeShips(Player player) {
        if (player.getName().equals("AI")) {
            randomPlacement();
        } else {
            String placementChoice = input.askUserInput("Choose placement method:\n[1] - manual\n[2] - random");
            if (placementChoice.equals("1")) {
                manualPlacement();
            } else if (placementChoice.equals("2")) {
                randomPlacement();
            } else {
                placeShips(player);
            }
        }
    }

    public void randomPlacement() {
        for (ShipType type : ShipType.values()) {
            tryRandomPlacement(type);
        }
    }

    public void manualPlacement() {
        for (ShipType type : ShipType.values()) {
            tryManualPlacement(type);
        }
    }


    private String getPlacementDirection() {
        String direction = input.askUserInput("Placement direction:\n[h] - horizontal\n[v] - vertical");
        if (direction.equals("h")) {
            return "horizontal";
        } else if (direction.equals("v")) {
            return "vertical";
        } else {
            return getPlacementDirection();
        }
    }

    private void tryManualPlacement(ShipType type) {
        int[] shipCoordinates = null;
        Ship ship = null;
        String direction = null;
        do {
            display.printBoard(board, true);
            direction = getPlacementDirection();
            String placement = input.askPlacementCoordinate(type);
            shipCoordinates = input.convertStringToMove(placement);
            ship = new Ship(type);
        } while (!board.isPlacementOk(shipCoordinates[0], shipCoordinates[1], ship, direction));
        placeShip(shipCoordinates[0], shipCoordinates[1], ship, direction);
    }

    private void tryRandomPlacement(ShipType type) {
        int directionRandom = 0;
        String direction = null;
        int x = 0;
        int y = 0;
        Ship ship;
        do {
            directionRandom = rand.nextInt(2);
            direction = directionRandom == 1 ? "horizontal" : "vertical";
            x = rand.nextInt(board.getOcean().length - type.shipSize);
            y = rand.nextInt(board.getOcean().length - type.shipSize);
            ship = new Ship(type);
        }while (!board.isPlacementOk(x, y, ship, direction));
        placeShip(x, y, ship, direction);
    }

    private void placeShip(int fromXCoordinate, int fromYCoordinate, Ship ship, String direction) {
        int shipSize = ship.getType().shipSize;
        if (direction.equals("horizontal")) {
            placeHorizontal(fromXCoordinate, fromYCoordinate, ship, shipSize);
        } else {
            placeVertical(fromXCoordinate, fromYCoordinate, ship, shipSize);
        }
        player.addShip(ship);
    }

    private void placeVertical(int fromXCoordinate, int fromYCoordinate, Ship ship, int shipSize) {
        int toXCoordinate = fromXCoordinate + shipSize;
        for (int row = fromXCoordinate; row < toXCoordinate; row++) {
            Square targetSquare = board.getSquare(row, fromYCoordinate);
            ship.addPosition(targetSquare);
        }
    }

    private void placeHorizontal(int fromXCoordinate, int fromYCoordinate, Ship ship, int shipSize) {
        int toYCoordinate = fromYCoordinate + shipSize;
        for (int column = fromYCoordinate; column < toYCoordinate; column++) {
            Square targetSquare = board.getSquare(fromXCoordinate, column);
            ship.addPosition(targetSquare);
        }
    }
}