package com.codecool.battleship.utility;

import java.util.Scanner;

public class Input {
    Scanner inputScan = new Scanner(System.in);
    Display display = new Display();

public String askPlacementCoordinate(String shipType) {
    while (true) {
        display.println("Where do you want to place the "+ shipType +" ship?");
        String userInput = inputScan.nextLine();
        if (isValidCoordinateForm(userInput)) {
            return userInput;
        }
    }
}
public String askAttackCoordinate(int player) {
    display.println("Player " + player + ", input an attack coordinate!");
    String userInput = inputScan.nextLine();
    return userInput;
}
public boolean isValidCoordinateForm(String userInput) {
    String reorderedInput = "";
    String charInputs = "";
    String integerInputs = "";
    for (char character : userInput.toUpperCase().toCharArray()) {
        if (Character.isDigit(character)) {
            integerInputs += character;
        } else {
            charInputs += character;
        }
    }
    reorderedInput += charInputs + integerInputs;
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
}
