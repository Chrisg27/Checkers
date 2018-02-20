package com.example.checkers.GameComponents;

import com.example.checkers.GameTypes.GeneralGame;
import com.example.checkers.Player.Player;

import java.util.ArrayList;

public class GameManager {

    private static BoardSquareManager squareManager = new BoardSquareManager();
    private static MainGameLoop gameLoop;
    private static BoardDisplay activityView;

    public static void setUpNewGame(GeneralGame gameType){
        gameLoop = new MainGameLoop(gameType);
    }

    public static void startNewGame(){
        gameLoop.startGame();
    }

    public static void setDisplay(BoardDisplay activity){
        activityView = activity;
    }

    public static BoardDisplay getDisplay(){
        return activityView;
    }

    public static BoardSquare getSquareAt(int rowIndex, int columnIndex){
        return squareManager.getBoardSquareAt(rowIndex, columnIndex);
    }

    public static void setSquareAt(int rowIndex, int columnIndex, BoardSquare square){
        squareManager.setBoardSquareAt(rowIndex, columnIndex, square);
    }

    public static void acceptInput(){
        squareManager.freeBoardSquares();
    }

    public static void blockInput(){
        squareManager.lockBoardSquares();
    }

    public static Player getCurrentTurn(){
        return gameLoop.getCurrentTurn();
    }

    public static void showMoves(ArrayList<BoardSquare> squares){
        squareManager.freeOnly(squares);
        squareManager.highlightSquares(squares);
    }

    public static void resetBoard(){
        squareManager.resetBoard();
    }

    public static void passInput(BoardSquare square){
        gameLoop.passInput(square);
    }

    public static void endGame(){
        activityView.finish();
        activityView = null;
    }
}
