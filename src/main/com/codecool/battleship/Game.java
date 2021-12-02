package com.codecool.battleship;

import com.codecool.battleship.core.HumanPlayer;
import com.codecool.battleship.core.Player;
import com.codecool.battleship.utility.*;

import java.util.Arrays;


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
        player1 = new HumanPlayer("Józsi");
        player2 = new HumanPlayer("Béla");
        currentRoundPlayer = player1;
    }

    public void gameCycle() {
        while (checkWin()) {
            display.printBoard(getOtherPlayer().getBoard(), false);
            playerShoot();
            changeCurrentPlayer();
        }
        display.printWinner(player1.isAlive() ? player1.getName() : player2.getName());
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
        if (Arrays.equals(validCoordinates, new int[]{00000000})) {
            initiateNukeCheat();
        } else {
            getOtherPlayer().getHit(validCoordinates[0], validCoordinates[1]);
        }
    }

    private boolean checkWin() {
        return player1.isAlive() && player2.isAlive();
    }
    private void initiateNukeCheat() {
        for (int row = 0; row < currentRoundPlayer.getBoard().getOcean().length; row++) {
            for (int col = 0; col < currentRoundPlayer.getBoard().getOcean().length; col++) {
                getOtherPlayer().getHit(row, col);
            }

        }
        display.printBoard(getOtherPlayer().getBoard(), false);
    }


}