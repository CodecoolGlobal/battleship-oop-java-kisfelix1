package com.codecool.battleship.core;

public class Square {

    public enum SquareStatus {
        EMPTY, SHIP, HIT, MISSED
        /*public GetCharacter(){
            //unicode representation
        }*/
    }

    private final int x;
    private final int y;
    private SquareStatus status;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        status = SquareStatus.EMPTY;
    }

    public SquareStatus getStatus() {
        return status;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return status.toString();
    }
}