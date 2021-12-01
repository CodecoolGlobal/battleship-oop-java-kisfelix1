package com.codecool.battleship.core;

import java.util.ArrayList;

public class Player {
    ArrayList<Ship> playerShips = new ArrayList<>();
    private Board board;
    private String name;

    public Player(String name) {
        BoardFactory boardFactory = new BoardFactory(this);
        this.name = name;
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
//    public void getHit() {
//        this.board.setOceanSquare();
//    }
}
