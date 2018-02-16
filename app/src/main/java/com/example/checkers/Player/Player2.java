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
        setKingRow(7);
    }

    @Override
    public void setPieceStartingPositions() {
        ArrayList<BoardSquare> positions = getPieceStartingPositions();

        positions.add(GameManager.getSquareAt(0,0));
        GameManager.getSquareAt(0, 0).setHasPiece(true);

        positions.add(GameManager.getSquareAt(0,2));
        GameManager.getSquareAt(0, 2).setHasPiece(true);

        positions.add(GameManager.getSquareAt(0,4));
        GameManager.getSquareAt(0, 4).setHasPiece(true);

        positions.add(GameManager.getSquareAt(0,6));
        GameManager.getSquareAt(0, 6).setHasPiece(true);

        positions.add(GameManager.getSquareAt(1,1));
        GameManager.getSquareAt(1, 1).setHasPiece(true);

        positions.add(GameManager.getSquareAt(1,3));
        GameManager.getSquareAt(1, 3).setHasPiece(true);

        positions.add(GameManager.getSquareAt(1,5));
        GameManager.getSquareAt(1, 5).setHasPiece(true);

        positions.add(GameManager.getSquareAt(1,7));
        GameManager.getSquareAt(1, 7).setHasPiece(true);

        positions.add(GameManager.getSquareAt(2,0));
        GameManager.getSquareAt(2, 0).setHasPiece(true);

        positions.add(GameManager.getSquareAt(2,2));
        GameManager.getSquareAt(2, 2).setHasPiece(true);

        positions.add(GameManager.getSquareAt(2,4));
        GameManager.getSquareAt(2, 4).setHasPiece(true);

        positions.add(GameManager.getSquareAt(2,6));
        GameManager.getSquareAt(2, 6).setHasPiece(true);
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