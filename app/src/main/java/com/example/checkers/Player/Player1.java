package com.example.checkers.Player;

import com.example.checkers.Colors.Player1PieceColor;
import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.BoardSquareManager;
import com.example.checkers.GamePieceComponents.GamePiece;
import com.example.checkers.GamePieceComponents.Player1Piece;

import java.io.IOException;
import java.util.ArrayList;

public class Player1 extends Player {

    public Player1(){
        super(new Player1PieceColor());
        setPieceStartingPositions();
        firstTimePieceSetUp();
        setKingRow(0);
    }

    //Used to initialize kingRow during deserialization
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        setKingRow(0);
    }

    @Override
    public void setPieceStartingPositions() {
        ArrayList<BoardSquare> positions = getPieceStartingPositions();

        positions.add(BoardSquareManager.getSquareAt(5,1));
        BoardSquareManager.getSquareAt(5, 1).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(5,3));
        BoardSquareManager.getSquareAt(5, 3).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(5,5));
        BoardSquareManager.getSquareAt(5, 5).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(5,7));
        BoardSquareManager.getSquareAt(5, 7).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(6,0));
        BoardSquareManager.getSquareAt(6, 0).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(6,2));
        BoardSquareManager.getSquareAt(6, 2).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(6,4));
        BoardSquareManager.getSquareAt(6, 4).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(6,6));
        BoardSquareManager.getSquareAt(6, 6).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(7,1));
        BoardSquareManager.getSquareAt(7, 1).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(7,3));
        BoardSquareManager.getSquareAt(7, 3).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(7,5));
        BoardSquareManager.getSquareAt(7, 5).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(7,7));
        BoardSquareManager.getSquareAt(7, 7).setHasPiece(true);
    }

    @Override
    public void firstTimePieceSetUp() {
        ArrayList<GamePiece> pieces = getPieces();
        ArrayList<BoardSquare> startingPositions = getPieceStartingPositions();

        for(int index = 0; index <= 11; index++){
            pieces.add(new Player1Piece(this, startingPositions.get(index)));
        }
    }

    @Override
    public String toString(){
        return "Player 1";
    }
}