package com.example.checkers.GamePieceComponents;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.Player.Player;
import java.util.ArrayList;

public class Player1Piece extends GamePiece {

    MoveHandler moveHandler = new Player1MoveHandler();

    public Player1Piece(Player owner, BoardSquare location){
        super(owner, location);
    }

    @Override
    public ArrayList<BoardSquare> getPossibleMoves() {

        ArrayList<BoardSquare> squares = new ArrayList<>();
        return moveHandler.verifyPossibleMoves(squares);
    }

    @Override
    public ArrayList<BoardSquare> getPossibleJumps() {

        ArrayList<BoardSquare> squares = new ArrayList<>();
        return moveHandler.verifyPossibleMoves(squares);
    }
}