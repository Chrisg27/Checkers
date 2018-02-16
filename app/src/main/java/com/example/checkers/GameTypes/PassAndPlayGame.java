package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.GameManager;

public class PassAndPlayGame extends GeneralGame {

    @Override
    public void postMove() {
        super.postMove();
        GameManager.resetBoard();
        switchTurns();
    }
}