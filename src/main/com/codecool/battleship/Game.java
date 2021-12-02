package com.codecool.battleship;

import com.codecool.battleship.core.ComputerPlayer;
import com.codecool.battleship.core.HumanPlayer;
import com.codecool.battleship.core.Player;
import com.codecool.battleship.utility.*;


public class Game {
    private static final Display display = new Display();
    private static final Input input = new Input();

    private Player player1;
    private Player player2;
    private Player currentRoundPlayer;

    public Game(String mode) {
        setup(mode);
    }

    private void setup(String mode) {
        player1 = new HumanPlayer("Józsi");
        player2 = mode.equals("1") ? new HumanPlayer("Béla") : new ComputerPlayer("AI");
        currentRoundPlayer = player1;
    }

    public void gameCycle() {
        while (checkWin()) {
            currentRoundPlayer.shoot(getOtherPlayer());
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

    private boolean checkWin() {
        return player1.isAlive() && player2.isAlive();
    }
}