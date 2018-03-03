package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.BoardSquareManager;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.GameComponents.UIManager;
import com.example.checkers.Player.Player;
import com.example.checkers.Player.Player1;
import com.example.checkers.Player.Player2;

public class PassAndPlayGame extends GeneralGame {

    public PassAndPlayGame(){
        setFileName("offline_game.dat");
    }

    @Override
    public void newGame(){
        setPlayer1(new Player1());
        setPlayer2(new Player2());
        setCurrentTurn(getPlayer1());
    }

    @Override
    public void loadGame(){
        getPlayer1().setUpLoadedPieceLocations();
        getPlayer2().setUpLoadedPieceLocations();
    }

    @Override
    public void checkForWinner(){
        Player otherPlayer = getOtherPlayer();
        if(otherPlayer.getNumberOfPiecesLeft() == 0) {
            GameManager.endGame(getFileName());
            UIManager.showWinEndGameFor(getCurrentTurn(), GameManager.getDisplay());
        }
    }

    @Override
    public void postMove() {
        super.postMove();
        switchTurns();
    }
}