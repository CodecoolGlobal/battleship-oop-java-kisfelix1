package com.codecool.battleship;

import com.codecool.battleship.core.Player;
import com.codecool.battleship.utility.*;


public class Game {
    private static final Display display = new Display();
    private static final Input input = new Input();

    private Player player1;
    private Player player2;
    private Player currentRoundPlayer;

    public Game() {
        setup();
    }

    private void setup() {
        player1 = new Player("Józsi");
        player2 = new Player("Béla");
        currentRoundPlayer = player1;
    }

    public void gameCycle() {
        while (!checkWin()) {
            display.printBoard(getOtherPlayer().getBoard());
            playerShoot();
            changeCurrentPlayer();
        }
    }

    private void changeCurrentPlayer() {
        if (currentRoundPlayer.getName().equals(player1.getName())) {
            currentRoundPlayer = player2;
        } else {
            currentRoundPlayer = player1;
        }
    }

    private Player getOtherPlayer() {
        if (currentRoundPlayer.getName().equals(player1.getName())) {
            return player2;
        } else {
            return player1;
        }
    }


    private void playerShoot() {
        int[] validCoordinates = input.askAttackCoordinate(currentRoundPlayer.getName(), getOtherPlayer().getBoard());
        getOtherPlayer().getHit(validCoordinates[0], validCoordinates[1]);
    }

    private boolean checkWin() {
        return false;
    }


}