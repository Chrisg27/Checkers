package com.example.checkers.GameComponents;

import com.example.checkers.GameTypes.GeneralGame;
import com.example.checkers.Player.Player;
import com.example.checkers.Player.Player1;
import com.example.checkers.Player.Player2;

public class MainGameLoop {

    private GeneralGame gameType;
    private Player currentTurn;
    private Player1 player1;
    private Player2 player2;

    public MainGameLoop(GeneralGame gameType){
        this.gameType = gameType;
    }

    public void startGame(){

        gameType.newGame();
        player1 = gameType.getPlayer1();
        player2 = gameType.getPlayer2();
        currentTurn = gameType.getPlayerTurn();

        player1.drawPieces();
        player2.drawPieces();

        GameManager.requestInput();
    }

    public void handleSquareInputs(BoardSquare square){
        if(gameType.isFirstSelection()) gameType.checkFirstSelectedSquare(square, currentTurn);
    }
}