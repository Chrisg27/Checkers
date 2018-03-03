package com.example.checkers.GameComponents;

import java.util.ArrayList;

public class BoardSquareManager {

    private static BoardSquare[][] squares = new BoardSquare[8][8];

    public static BoardSquare getSquareAt(int rowIndex, int columnIndex){
        return squares[rowIndex][columnIndex];
    }

    public static void setSquareAt(int rowIndex, int columnIndex, BoardSquare square){
        squares[rowIndex][columnIndex] = square;
    }

    public static void highlightSquares(ArrayList<BoardSquare> squares){
        for(BoardSquare square : squares){
            square.highlight();
        }
    }

    public static void freeOnly(ArrayList<BoardSquare> squares){
        for(BoardSquare square : squares){
            square.setEnabled(true);
        }
    }

    public static void setNewGameBoard(){
        squares = new BoardSquare[8][8];
    }

    public static void resetBoard(){
        freeBoardSquares();

        for(BoardSquare[] squareArray : squares){
            for(BoardSquare square : squareArray){
                if(square.isHighlighted()) square.unhighlight();
                if(square.isChecked()) square.toggle();
            }
        }
    }

    public static void lockBoardSquares(){
        for(BoardSquare[] squareArray : squares){
            for(BoardSquare square : squareArray){
                square.setEnabled(false);
            }
        }
    }

    public static void freeBoardSquares(){
        for(BoardSquare[] squareArray : squares){
            for(BoardSquare square : squareArray){
                square.setEnabled(true);
            }
        }
    }
}