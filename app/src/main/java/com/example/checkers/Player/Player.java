package com.example.checkers.Player;

import com.example.checkers.Colors.PieceColor;
import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GamePieceComponents.GamePiece;
import java.util.ArrayList;

public abstract class Player {

    private int numberOfPiecesLeft = 12;
    private PieceColor color;
    private ArrayList<GamePiece> pieces = new ArrayList<>();
    private ArrayList<BoardSquare> pieceStartingPositions = new ArrayList<>();

    public Player(PieceColor color){
        this.color = color;
    }

    public abstract void setPieceStartingPositions();
    public abstract void firstTimePieceSetUp();

    public void decreasePieceCount(){
        numberOfPiecesLeft --;
    }
    public int getNumberOfPiecesLeft(){
        return numberOfPiecesLeft;
    }
    public ArrayList<GamePiece> getPieces(){
        return pieces;
    }
    public void setPieces(ArrayList<GamePiece> pieces){
        this.pieces = pieces;
    }
    public PieceColor getColor(){
        return color;
    }

    public void setPieceStartingPositions(ArrayList<BoardSquare> positions){
        pieceStartingPositions = positions;
    }

    public void drawPieces(){
        for(int index = 0; index < numberOfPiecesLeft; index++){
            GamePiece currentPiece = pieces.get(index);
            currentPiece.drawPiece();
        }
    }

    public ArrayList<BoardSquare> getPieceStartingPositions(){
        return pieceStartingPositions;
    }
}