#!/bin/sh

find -name *.java | xargs javac
java -classpath src/main/java com.codecool.battleship.Battleship

