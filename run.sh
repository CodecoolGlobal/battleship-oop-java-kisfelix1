#!/bin/sh

find -name *.java | xargs javac
java -classpath src/main/ com.codecool.battleship.Battleship

