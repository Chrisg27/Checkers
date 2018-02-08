package com.example.checkers.Player;

import com.example.checkers.Colors.Player1PieceColor;
import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.GamePieceComponents.GamePiece;
import com.example.checkers.GamePieceComponents.Player1Piece;

import java.util.ArrayList;

public class Player1 extends Player {

    public Player1(){
        super(new Player1PieceColor());
        setPieceStartingPositions();
        firstTimePieceSetUp();
    }

    @Override
    public void setPieceStartingPositions() {
        ArrayList<BoardSquare> positions = getPieceStartingPositions();

        positions.add(GameManager.getSquareAt(5,1));
        positions.add(GameManager.getSquareAt(5,3));
        positions.add(GameManager.getSquareAt(5,5));
        positions.add(GameManager.getSquareAt(5,7));
        positions.add(GameManager.getSquareAt(6,0));
        positions.add(GameManager.getSquareAt(6,2));
        positions.add(GameManager.getSquareAt(6,4));
        positions.add(GameManager.getSquareAt(6,6));
        positions.add(GameManager.getSquareAt(7,1));
        positions.add(GameManager.getSquareAt(7,3));
        positions.add(GameManager.getSquareAt(7,5));
        positions.add(GameManager.getSquareAt(7,7));
    }

    @Override
    public void firstTimePieceSetUp() {
        ArrayList<GamePiece> pieces = getPieces();
        ArrayList<BoardSquare> startingPositions = getPieceStartingPositions();

        for(int index = 0; index <= 11; index++){
            pieces.add(new Player1Piece(this, startingPositions.get(index)));
        }
    }
}