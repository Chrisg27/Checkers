package com.example.checkers.GameComponents;

public class BoardSquareManager {

    private BoardSquare[][] squares = new BoardSquare[8][8];

    public BoardSquare getBoardSquareAt(int rowIndex, int columnIndex){
        return squares[rowIndex][columnIndex];
    }

    public void setBoardSquareAt(int rowIndex, int columnIndex, BoardSquare square){
        squares[rowIndex][columnIndex] = square;
    }

    public void lockBoardSquares(){

        for(int rowIndex = 0; rowIndex <= 7; rowIndex++){
            for(int columnIndex = 0; columnIndex <= 7; columnIndex++){
                squares[rowIndex][columnIndex].setClickable(false);
            }
        }
    }

    public void freeBoardSquares(){

        for(int rowIndex = 0; rowIndex <= 7; rowIndex++){
            for(int columnIndex = 0; columnIndex <= 7; columnIndex++){
                squares[rowIndex][columnIndex].setClickable(true);
            }
        }
    }
}
