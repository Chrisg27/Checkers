package com.example.checkers.GameComponents;

import com.example.checkers.GameTypes.GeneralGame;

public class GameManager {

    private static BoardSquareManager squareManager = new BoardSquareManager();
    private static MainGameLoop gameLoop;
    private static BoardDisplay boardDisplay;

    public static void setUpNewGame(GeneralGame gameType){
        gameLoop = new MainGameLoop(gameType);
    }

    public static void startNewGame(){
        gameLoop.startGame();
    }

    public static BoardSquare getSquareAt(int rowIndex, int columnIndex){
        return squareManager.getBoardSquareAt(rowIndex, columnIndex);
    }

    public static void setSquareAt(int rowIndex, int columnIndex, BoardSquare square){
        squareManager.setBoardSquareAt(rowIndex, columnIndex, square);
    }

    public static void checkSelection(BoardSquare square){
        gameLoop.handleSquareInputs(square);
    }

    //doesn't actually return an input but frees up the squares which allows the squares to be clicked
    public static void requestInput(){
        squareManager.freeBoardSquares();
    }
}
