package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.BoardSquareManager;
import com.example.checkers.GameComponents.UIManager;

public class AIGame extends GeneralGame {

    @Override
    public void postMove() {
        super.postMove();
        BoardSquareManager.resetBoard();
        UIManager.blockInput();
        switchTurns();
    }
}
