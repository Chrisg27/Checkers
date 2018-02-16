package com.example.checkers.GamePieceComponents;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.Player.Player;

import java.util.ArrayList;
import java.util.logging.Handler;

public abstract class GamePiece {

    private int pieceImageId;
    private Player owner;
    private BoardSquare location;
    private MoveHandler moveHandler;

    public GamePiece(Player owner, BoardSquare location){

        this.owner = owner;
        this.location = location;
        this.pieceImageId = owner.getColor().getPieceImageId();
        this.moveHandler = new MoveHandler();
    }

    public abstract ArrayList<BoardSquare> getPossibleMoves();
    public abstract ArrayList<BoardSquare> getPossibleJumps();

    public void setLocation(BoardSquare location){
        this.location = location;
    }
    public BoardSquare getLocation(){
        return location;
    }
    public Player getOwner(){return owner;}
    public void setOwner(Player owner){
        this.owner = owner;
    }
    public int getPieceImageId(){
        return pieceImageId;
    }
    public void setPieceImageId(int pieceImageId){
        this.pieceImageId = pieceImageId;
    }
    public void drawPiece(){
        location.setImageResource(pieceImageId);
    }
    public MoveHandler getMoveHandler(){
        return moveHandler;
    }
    public BoardSquare getJumpedSquareFor(BoardSquare newLocation){
        return moveHandler.getJumpedSquare(this.location, newLocation);
    }

    public void moveTo(BoardSquare square){
        square.setHasPiece(true);
        square.setImageResource(getPieceImageId());

        location.setHasPiece(false);
        location.setImageResource(android.R.color.transparent);

        location = square;
    }
}