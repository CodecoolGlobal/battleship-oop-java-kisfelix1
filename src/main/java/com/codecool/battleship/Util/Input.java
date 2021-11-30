package com.codecool.battleship.Util;

import java.util.Scanner;

public class Input {
    Scanner inputScan = new Scanner(System.in);
    Display display = new Display();

public String askPlacementCoordinate() {
    while (true) {
        display.println("Where do you want to place the (PLACEHOLDER FOR SHIPTYPE) ship?");
        String userInput = inputScan.nextLine();
        if (validateCoordinate(userInput)) {
            return userInput;
        }
    }
}
public String askAttackCoordinate(int player) {
    display.println("Player " + player + ", input an attack coordinate!");
    String userInput = inputScan.nextLine();
    return userInput;
}
public boolean validateCoordinate(String userInput) {
    // VALIDATE NEEDED
    return true;
}
}
