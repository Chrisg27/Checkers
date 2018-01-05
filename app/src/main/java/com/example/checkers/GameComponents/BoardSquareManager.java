package com.example.checkers.GameComponents;

public class BoardSquareManager {

    private BoardSquare[][] squares = new BoardSquare[8][8];

    public BoardSquare getBoardSquareAt(int rowIndex, int columnIndex){
        return squares[rowIndex][columnIndex];
    }

    public void setBoardSquareAt(int rowIndex, int columnIndex, BoardSquare square){
        squares[rowIndex][columnIndex] = square;
    }
}
