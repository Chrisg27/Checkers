package com.example.checkers.Player;

import com.example.checkers.Colors.Player2PieceColor;
import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.GamePieceComponents.GamePiece;
import com.example.checkers.GamePieceComponents.Player2Piece;

import java.util.ArrayList;

public class Player2 extends Player {

    public Player2(){
        super(new Player2PieceColor());
        setPieceStartingPositions();
        firstTimePieceSetUp();
    }

    @Override
    public void setPieceStartingPositions() {
        ArrayList<BoardSquare> positions = getPieceStartingPositions();

        positions.add(GameManager.getSquareAt(0,0));
        positions.add(GameManager.getSquareAt(0,2));
        positions.add(GameManager.getSquareAt(0,4));
        positions.add(GameManager.getSquareAt(0,6));
        positions.add(GameManager.getSquareAt(1,1));
        positions.add(GameManager.getSquareAt(1,3));
        positions.add(GameManager.getSquareAt(1,5));
        positions.add(GameManager.getSquareAt(1,7));
        positions.add(GameManager.getSquareAt(2,0));
        positions.add(GameManager.getSquareAt(2,2));
        positions.add(GameManager.getSquareAt(2,4));
        positions.add(GameManager.getSquareAt(2,6));
    }

    @Override
    public void firstTimePieceSetUp() {
        ArrayList<GamePiece> pieces = getPieces();
        ArrayList<BoardSquare> startingPositions = getPieceStartingPositions();

        for(int index = 0; index <= 11; index++){
            pieces.add(new Player2Piece(this, startingPositions.get(index)));
        }
    }
}