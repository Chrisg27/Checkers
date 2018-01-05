package com.example.checkers.GameComponents;

import com.example.checkers.R;

public class GamePiece {

    private String color;
    private boolean isKing = false;
    private int pieceImageId;

    public GamePiece(String color, boolean isKing){

        this.color = color;
        this.isKing = isKing;

        if(color.equals("red")){
            if(isKing) pieceImageId = R.drawable.checker_red_king;
            else pieceImageId = R.drawable.checker_red;
        }

        else if(color.equals("black")){
            if(isKing) pieceImageId = R.drawable.checker_black_king;
            else pieceImageId = R.drawable.checker_black;
        }
    }

    public String getColor(){
        return color;
    }

    public boolean isKing(){
        return isKing;
    }

    public void setKing(){
        isKing = true;
    }

    public int getPieceImageId(){
        return pieceImageId;
    }
}
