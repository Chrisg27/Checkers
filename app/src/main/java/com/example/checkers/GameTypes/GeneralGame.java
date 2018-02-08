package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.Player.Player;
import com.example.checkers.Player.Player1;
import com.example.checkers.Player.Player2;

public abstract class GeneralGame {

    private boolean isFirstSelection;
    private Player playerTurn;
    private Player1 player1;
    private Player2 player2;

    public GeneralGame(){
    }

    public Player1 getPlayer1(){
        return player1;
    }
    public Player2 getPlayer2(){
        return player2;
    }
    public boolean isFirstSelection(){
        return isFirstSelection;
    }
    public boolean checkFirstSelectedSquare(BoardSquare square, Player playerTurn){
        return false;
    }
    public void switchTurns(){
        playerTurn = (playerTurn == player1) ? player2 : player1;
    }
    public Player getPlayerTurn(){
        return playerTurn;
    }

    public void newGame(){
        player1 = new Player1();
        player2 = new Player2();
    }

    public void showPossibleMovesAndJumpsFor(BoardSquare square){
    }

    private void checkedForJumpedPiece(){
    }
}