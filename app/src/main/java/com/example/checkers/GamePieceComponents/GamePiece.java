package com.example.checkers.GamePieceComponents;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.Player.Player;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Handler;

public abstract class GamePiece implements Serializable{

    //used to keep track of location during serialization
    private int locationRowIndex;
    private int locationColumnIndex;

    private int pieceImageId;
    private Player owner;

    private transient MoveHandler moveHandler;
    private transient BoardSquare location;

    public GamePiece(Player owner, BoardSquare location){

        this.owner = owner;
        this.location = location;
        this.pieceImageId = owner.getColor().getPieceImageId();
        moveHandler = new MoveHandler();
        locationRowIndex = location.getRowIndex();
        locationColumnIndex = location.getColumnIndex();
    }

    //Used to initialize moveHandler during deserialization
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        moveHandler = new MoveHandler();
    }

    public abstract ArrayList<BoardSquare> getPossibleMoves();
    public abstract ArrayList<BoardSquare> getPossibleJumps();

    public void setLocation(BoardSquare location){
        this.location = location;
        locationRowIndex = location.getRowIndex();
        locationColumnIndex = location.getColumnIndex();
    }
    public BoardSquare getLocation(){
        return location;
    }
    public Player getOwner(){return owner;}
    public void setOwner(Player owner){
        this.owner = owner;
    }
    public void setLocationRowIndex(int index){locationRowIndex = index;}
    public void setLocationColumnIndex(int index){locationColumnIndex = index;}
    public int getLocationRowIndex(){return locationRowIndex;}
    public int getLocationColumnIndex(){return locationColumnIndex;}
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
}