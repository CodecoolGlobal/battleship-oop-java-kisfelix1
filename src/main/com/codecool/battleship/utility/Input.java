package com.codecool.battleship.utility;

import com.codecool.battleship.core.Board;
import com.codecool.battleship.core.ShipType;

import java.util.Scanner;

public class Input {
    private static final int ASCII_VALUE_OF_A = 97;
    Scanner inputScan = new Scanner(System.in);
    Display display = new Display();

    public String askPlacementCoordinate(ShipType shipType) {
        while (true) {
            display.println("Where do you want to place the " + shipType + " ship?");
            String userInput = inputScan.nextLine();
            if (isValidCoordinateForm(userInput)) {
                return userInput;
            }
        }
    }

    public int[] convertStringToMove(String move) {
        int[] coordinates = new int[2];
        coordinates[0] = move.charAt(0) - ASCII_VALUE_OF_A;
        coordinates[1] = Integer.parseInt(move.substring(1)) - 1;
        return coordinates;
    }

    public String askAttackCoordinate(int player, Board attackedBoard) {
        display.println("Player " + player + ", input an attack coordinate!");
        String userInput = inputScan.nextLine();
        while (!isValidCoordinateForm(userInput) && !isInsideBoard(userInput, attackedBoard)) {
            display.println(isValidCoordinateForm(userInput) ? "Invalid coordinate. " : "Coordinate out of bound. ");
            display.print("Please try again!");
            userInput = inputScan.nextLine();
        }
        return userInput;
    }

    public boolean isValidCoordinateForm(String userInput) {
        String reorderedInput = reorderPlayerInputs(userInput);
        char[] inputCharArray = reorderedInput.toCharArray();
        if (reorderedInput.length() == 2 || reorderedInput.length() == 3) {
            if (Character.isAlphabetic(inputCharArray[0])) {
                return reorderedInput.length() == 2 ?
                        Character.isDigit(inputCharArray[1]) :
                        Character.isDigit(inputCharArray[1])
                                && Character.isDigit(inputCharArray[2]);
            }
        }
        return false;
    }

    public boolean isInsideBoard(String userInput, Board attackedBoard) {
        int upperAAscii = 65;
        String reorderedInput = reorderPlayerInputs(userInput);
        char[] inputCharArray = reorderedInput.toCharArray();
        int firstCoordinate = (int) inputCharArray[0] - upperAAscii;
        int secondCoordinate = (userInput.length() == 2 ? inputCharArray[1] : inputCharArray[1] + inputCharArray[2]) - 1;
        return firstCoordinate >= 0 &&
                firstCoordinate < attackedBoard.getOcean().length &&
                secondCoordinate >= 0 &&
                secondCoordinate < attackedBoard.getOcean().length;
    }

    public String reorderPlayerInputs(String userInput) {
        String charInputs = "";
        String integerInputs = "";
        for (char character : userInput.toUpperCase().toCharArray()) {
            if (Character.isDigit(character)) {
                integerInputs += character;
            } else {
                charInputs += character;
            }
        }
        return charInputs + integerInputs;
    }

    public String askUserInput() {
        return inputScan.nextLine();
    }
}
