package com.example.checkers.Player;

import com.example.checkers.Colors.PieceColor;
import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.GamePieceComponents.GamePiece;
import com.example.checkers.GamePieceComponents.KingPiece;

import java.util.ArrayList;

public abstract class Player {

    private int numberOfPiecesLeft = 12;
    private PieceColor color;
    private ArrayList<GamePiece> pieces = new ArrayList<>();
    private ArrayList<BoardSquare> pieceStartingPositions = new ArrayList<>();
    private int kingRow;

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
    public ArrayList<BoardSquare> getPieceStartingPositions(){
        return pieceStartingPositions;
    }
    public PieceColor getColor(){
        return color;
    }
    public void setKingRow(int row){
        kingRow = row;
    }
    public int getKingRow(){
        return kingRow;
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

    public void kingPiece(GamePiece piece){
        GamePiece kingPiece = new KingPiece(piece.getOwner(), piece.getLocation());
        kingPiece.setPieceImageId(getColor().getKingPieceImageId());
        kingPiece.getLocation().setImageResource(kingPiece.getPieceImageId());
        int replaceableIndex = pieces.indexOf(piece);
        pieces.set(replaceableIndex, kingPiece);
    }

    public GamePiece getPieceAtLocation(BoardSquare square){

        for(GamePiece piece : pieces){
            if(piece.getLocation() == square) return piece;

        } return null;
    }

    public boolean doesPieceHaveLocation(BoardSquare location){

        for(GamePiece piece : pieces){
            if(piece.getLocation() == location) return true;

        } return false;
    }

    public void removePiece(GamePiece piece){
        piece.getLocation().setImageResource(android.R.color.transparent);
        piece.getLocation().setHasPiece(false);
        getPieces().remove(piece);
    }
}