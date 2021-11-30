package com.codecool.battleship.core;

import java.util.ArrayList;

public class Ship {
    private ArrayList<Square> shipPositions = new ArrayList<>();

    public enum ShipType {
        CARRIER(5), BATTLESHIP(4), SUBMARINE(3), DESTROYER(2);
        public int shipSize;

        ShipType(int size) {
            shipSize = size;
        }
    }
    public ShipType type;


    public Ship(ShipType type) {
        this.type = type;
    }

    public ArrayList<Square> getPositions() {
        return shipPositions;
    }

    public void addPosition(Square square){
        shipPositions.add(square);
        square.setStatus(Square.SquareStatus.SHIP);
    }

}
