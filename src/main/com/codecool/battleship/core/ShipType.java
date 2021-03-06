package com.codecool.battleship.core;

public enum ShipType {
    CARRIER(5), BATTLESHIP(4), SUBMARINE(3), DESTROYER(2);
    public int shipSize;

    ShipType(int size) {
        shipSize = size;
    }
}
