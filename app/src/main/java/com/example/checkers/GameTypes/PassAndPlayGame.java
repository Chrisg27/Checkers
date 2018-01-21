package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.BoardSquare;

public class PassAndPlayGame extends GeneralGame {

    public boolean checkFirstSelectedSquare(BoardSquare square){

        return false;
    }
    public boolean switchTurns(){

        return false;
    }
}
