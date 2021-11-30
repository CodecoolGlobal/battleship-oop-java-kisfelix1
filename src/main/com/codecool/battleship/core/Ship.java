package com.codecool.battleship.core;

import java.util.ArrayList;

public class Ship {
    private ArrayList<Square> shipPositions = new ArrayList<Square>();

    public enum ShipType {
        CARRIER(5), CRUISER(3), BATTLESHIP(4), SUBMARINE(3), DESTROYER(2);
        public int shipSize;

        ShipType(int size) {
            size = shipSize;
        }
    }


    private ArrayList<Square> shipPositions = new ArrayList<>();
    public ShipType type;


    public Ship(ShipType type, Square... squares) {
        for (Square square : squares) {
            this.shipPositions.add(square);
        }
    }

    public ArrayList<Square> getPositions() {
        return shipPositions;
    }

}
