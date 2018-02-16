package com.example.checkers.GameComponents;

import java.util.ArrayList;

public class BoardSquareManager {

    private BoardSquare[][] squares = new BoardSquare[8][8];

    public BoardSquare getBoardSquareAt(int rowIndex, int columnIndex){
        return squares[rowIndex][columnIndex];
    }

    public void setBoardSquareAt(int rowIndex, int columnIndex, BoardSquare square){
        squares[rowIndex][columnIndex] = square;
    }

    public void highlightSquares(ArrayList<BoardSquare> squares){
        for(BoardSquare square : squares){
            square.highlight();
        }
    }

    public void freeOnly(ArrayList<BoardSquare> squares){

        for(BoardSquare square : squares){
            square.setEnabled(true);
        }
    }

    public void resetBoard(){

        freeBoardSquares();

        for(int rowIndex = 0; rowIndex <= 7; rowIndex++){
            for(int columnIndex = 0; columnIndex <= 7; columnIndex++){
                if(squares[rowIndex][columnIndex].isHighlighted()) squares[rowIndex][columnIndex].unhighlight();
                if(squares[rowIndex][columnIndex].isChecked()) squares[rowIndex][columnIndex].toggle();
            }
        }
    }

    public void lockBoardSquares(){
        for(int rowIndex = 0; rowIndex <= 7; rowIndex++){
            for(int columnIndex = 0; columnIndex <= 7; columnIndex++){
                squares[rowIndex][columnIndex].setEnabled(false);
            }
        }
    }

    public void freeBoardSquares(){
        for(int rowIndex = 0; rowIndex <= 7; rowIndex++){
            for(int columnIndex = 0; columnIndex <= 7; columnIndex++){
                squares[rowIndex][columnIndex].setEnabled(true);
            }
        }
    }
}