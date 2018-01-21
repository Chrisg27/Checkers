package com.example.checkers.GameComponents;

import com.example.checkers.GameTypes.GeneralGame;

public class MainGameLoop {

    private GeneralGame gameType;
    private String playerTurn;
    private boolean isFirstSelection = true;

    public MainGameLoop(GeneralGame gameType){
        this.gameType = gameType;
    }

    public void startGame(){
        playerTurn = gameType.getPlayerTurn();
        GameManager.requestInput();
    }

    public void handleSquareInputs(BoardSquare square){
        if(isFirstSelection) gameType.checkFirstSelectedSquare(square);
    }
}