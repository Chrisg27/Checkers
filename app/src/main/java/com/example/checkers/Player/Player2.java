package com.example.checkers.Player;

import com.example.checkers.Colors.Player2PieceColor;
import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.BoardSquareManager;
import com.example.checkers.GamePieceComponents.GamePiece;
import com.example.checkers.GamePieceComponents.Player2Piece;

import java.io.IOException;
import java.util.ArrayList;

public class Player2 extends Player {

    public Player2(){
        super(new Player2PieceColor());
        setPieceStartingPositions();
        firstTimePieceSetUp();
        setKingRow(7);
    }

    //Used to initialize kingRow during deserialization
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        setKingRow(7);
    }

    @Override
    public void setPieceStartingPositions() {
        ArrayList<BoardSquare> positions = getPieceStartingPositions();

        positions.add(BoardSquareManager.getSquareAt(0,0));
        BoardSquareManager.getSquareAt(0, 0).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(0,2));
        BoardSquareManager.getSquareAt(0, 2).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(0,4));
        BoardSquareManager.getSquareAt(0, 4).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(0,6));
        BoardSquareManager.getSquareAt(0, 6).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(1,1));
        BoardSquareManager.getSquareAt(1, 1).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(1,3));
        BoardSquareManager.getSquareAt(1, 3).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(1,5));
        BoardSquareManager.getSquareAt(1, 5).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(1,7));
        BoardSquareManager.getSquareAt(1, 7).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(2,0));
        BoardSquareManager.getSquareAt(2, 0).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(2,2));
        BoardSquareManager.getSquareAt(2, 2).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(2,4));
        BoardSquareManager.getSquareAt(2, 4).setHasPiece(true);

        positions.add(BoardSquareManager.getSquareAt(2,6));
        BoardSquareManager.getSquareAt(2, 6).setHasPiece(true);
    }

    @Override
    public void firstTimePieceSetUp() {
        ArrayList<GamePiece> pieces = getPieces();
        ArrayList<BoardSquare> startingPositions = getPieceStartingPositions();

        for(int index = 0; index <= 11; index++){
            pieces.add(new Player2Piece(this, startingPositions.get(index)));
        }
    }

    @Override
    public String toString(){
        return "Player 2";
    }
}