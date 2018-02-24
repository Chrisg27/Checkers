package com.example.checkers.GameComponents;

import java.util.ArrayList;

public class UIManager {

    public static void acceptInput(){
        BoardSquareManager.freeBoardSquares();
    }

    public static void blockInput(){
        BoardSquareManager.lockBoardSquares();
    }

    public static void showMoves(ArrayList<BoardSquare> squares){
        BoardSquareManager.freeOnly(squares);
        BoardSquareManager.highlightSquares(squares);
    }

    public static void resetBoard(){
        BoardSquareManager.resetBoard();
    }
}
