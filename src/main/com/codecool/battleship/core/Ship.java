package com.codecool.battleship.core;

import java.util.ArrayList;

public class Ship {
    private ArrayList<Square> shipPositions = new ArrayList<>();

    private ShipType type;


    public Ship(ShipType type) {
        this.type = type;
    }

    public ArrayList<Square> getPositions() {
        return shipPositions;
    }

    public void addPosition(Square square) {
        shipPositions.add(square);
        square.setStatus(SquareStatus.SHIP);
    }

    public ShipType getType() {
        return type;
    }
}
