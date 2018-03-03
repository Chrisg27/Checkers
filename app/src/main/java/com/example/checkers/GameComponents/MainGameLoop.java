package com.example.checkers.GameComponents;

import com.example.checkers.GameTypes.GeneralGame;
import com.example.checkers.Player.Player;
import com.example.checkers.Player.Player1;
import com.example.checkers.Player.Player2;

public class MainGameLoop {

    private GeneralGame gameType;
    private Player1 player1;
    private Player2 player2;

    public MainGameLoop(GeneralGame gameType){
        this.gameType = gameType;
    }

    public void startNewGame(){

        gameType.newGame();
        player1 = gameType.getPlayer1();
        player2 = gameType.getPlayer2();

        player1.drawPieces();
        player2.drawPieces();

        UIManager.acceptInput();
    }

    public void startSavedGame(){

        gameType.loadGame();
        player1 = gameType.getPlayer1();
        player2 = gameType.getPlayer2();

        player1.drawPieces();
        player2.drawPieces();

        UIManager.acceptInput();
    }

    public GeneralGame getGame(){
        return gameType;
    }

    public void passInput(BoardSquare square){
        gameType.handleInput(square);
    }

    public Player getCurrentTurn(){
        return gameType.getCurrentTurn();
    }
}