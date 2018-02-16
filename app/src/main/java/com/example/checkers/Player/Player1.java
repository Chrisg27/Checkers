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
        setKingRow(0);
    }

    @Override
    public void setPieceStartingPositions() {
        ArrayList<BoardSquare> positions = getPieceStartingPositions();

        positions.add(GameManager.getSquareAt(5,1));
        GameManager.getSquareAt(5, 1).setHasPiece(true);

        positions.add(GameManager.getSquareAt(5,3));
        GameManager.getSquareAt(5, 3).setHasPiece(true);

        positions.add(GameManager.getSquareAt(5,5));
        GameManager.getSquareAt(5, 5).setHasPiece(true);

        positions.add(GameManager.getSquareAt(5,7));
        GameManager.getSquareAt(5, 7).setHasPiece(true);

        positions.add(GameManager.getSquareAt(6,0));
        GameManager.getSquareAt(6, 0).setHasPiece(true);

        positions.add(GameManager.getSquareAt(6,2));
        GameManager.getSquareAt(6, 2).setHasPiece(true);

        positions.add(GameManager.getSquareAt(6,4));
        GameManager.getSquareAt(6, 4).setHasPiece(true);

        positions.add(GameManager.getSquareAt(6,6));
        GameManager.getSquareAt(6, 6).setHasPiece(true);

        positions.add(GameManager.getSquareAt(7,1));
        GameManager.getSquareAt(7, 1).setHasPiece(true);

        positions.add(GameManager.getSquareAt(7,3));
        GameManager.getSquareAt(7, 3).setHasPiece(true);

        positions.add(GameManager.getSquareAt(7,5));
        GameManager.getSquareAt(7, 5).setHasPiece(true);

        positions.add(GameManager.getSquareAt(7,7));
        GameManager.getSquareAt(7, 7).setHasPiece(true);
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