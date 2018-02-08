package com.example.checkers.GamePieceComponents;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.Player.Player;

import java.util.ArrayList;

public class KingPiece extends GamePiece {

    public KingPiece(Player owner, BoardSquare location){
        super(owner, location);
    }

    @Override
    public ArrayList<BoardSquare> getPossibleMoves() {
        return null;
    }

    @Override
    public ArrayList<BoardSquare> getPossibleJumps() {
        return null;
    }

    @Override
    public void drawPiece(){
        getLocation().setImageResource(getOwner().getColor().getKingPieceImageId());
    }
}
