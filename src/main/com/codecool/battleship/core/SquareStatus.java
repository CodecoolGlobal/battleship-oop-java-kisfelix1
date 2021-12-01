package com.codecool.battleship.core;

public enum SquareStatus {
    EMPTY("\u25E6"), SHIP("\u25AA"), HIT("\u25EC"), MISSED("\u25A1");
    public String unicodeCharacter;

    SquareStatus(String character) {
        unicodeCharacter = character;
    }
}
