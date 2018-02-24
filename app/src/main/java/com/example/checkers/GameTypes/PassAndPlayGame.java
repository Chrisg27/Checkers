package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.BoardSquareManager;

public class PassAndPlayGame extends GeneralGame {

    public PassAndPlayGame(){
        setFileName("offline_game.dat");
    }

    @Override
    public void postMove() {
        super.postMove();
        BoardSquareManager.resetBoard();
        switchTurns();
    }
}