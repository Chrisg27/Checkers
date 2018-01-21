package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.BoardSquare;

public abstract class GeneralGame {

    private String playerTurn;

    public abstract boolean checkFirstSelectedSquare(BoardSquare square);
    public abstract boolean switchTurns();

    public String getPlayerTurn(){
        return playerTurn;
    }

    public void showPossibleMovesAndJumpsFor(BoardSquare square){

    }

    private void checkedForJumpedPiece(){

    }
}
