package com.example.checkers.GameComponents;

import com.example.checkers.GameTypes.GeneralGame;

public class GameManager {

    private static BoardSquareManager squareManager = new BoardSquareManager();
    private static MainGameLoop gameLoop;
    private static BoardDisplay boardDisplay;

    public static void setUpNewGame(GeneralGame gameType){
        gameLoop = new MainGameLoop(gameType);
        gameLoop.startGame();
    }

    public static BoardSquare getSquareAt(int rowIndex, int columnIndex){
        return squareManager.getBoardSquareAt(rowIndex, columnIndex);
    }

    public static void setSquareAt(int rowIndex, int columnIndex, BoardSquare square){
        squareManager.setBoardSquareAt(rowIndex, columnIndex, square);
    }
}
