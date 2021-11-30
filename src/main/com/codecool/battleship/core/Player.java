package com.codecool.battleship.core;

import java.util.ArrayList;

public class Player {
    ArrayList<Ship> playerShips = new ArrayList<Ship>();
    public Board board;

    public Player() {
        BoardFactory boardFactory = new BoardFactory(this);
    }

    public void addShip(Ship ship) {
        playerShips.add(ship);
    }

    public boolean isAlive() {
        for (Ship playerShip : playerShips) {
            for (Square shipSquare : playerShip.getPositions()) {
                if (shipSquare.getStatus() == Square.SquareStatus.SHIP) {
                    return true;
                }
            }
        }
        return false;
    }
}
