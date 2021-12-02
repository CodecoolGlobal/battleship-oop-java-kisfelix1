package com.codecool.battleship.core;

import java.util.ArrayList;

import static com.codecool.battleship.core.SquareStatus.HIT;

public abstract class Player {
    protected ArrayList<Ship> playerShips = new ArrayList<>();
    protected Board board;
    protected String name;

    public Player(String name) {
        this.name = name;
        BoardFactory boardFactory = new BoardFactory(this);
    }

    public String getName(){
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public void addShip(Ship ship) {
        playerShips.add(ship);
    }

    public boolean isAlive() {
        for (Ship playerShip : playerShips) {
            for (Square shipSquare : playerShip.getPositions()) {
                if (shipSquare.getStatus() == SquareStatus.SHIP) {
                    return true;
                }
            }
        }
        return false;
    }

    public void getHit(int x, int y) {
        this.board.setSquareStatusHit(x, y);
    }

    public abstract void shoot(Player player);
}
