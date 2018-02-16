package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.GameManager;

public class AIGame extends GeneralGame {

    @Override
    public void postMove() {
        super.postMove();
        GameManager.resetBoard();
        GameManager.blockInput();
        switchTurns();
    }
}
