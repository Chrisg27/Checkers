package com.example.checkers.GamePieceComponents;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.Player.Player;

import java.util.ArrayList;

public class KingPiece extends GamePiece {

    public KingPiece(Player owner, BoardSquare location){
        super(owner, location);
    }

    @Override
    public ArrayList<BoardSquare> getPossibleMoves(){

        ArrayList<BoardSquare> possibleMoves = new ArrayList<>();
        int row = getLocation().getRowIndex();
        int column = getLocation().getColumnIndex();

        if(row - 1 >= 0 && column - 1 >= 0) possibleMoves.add(GameManager.getSquareAt(row - 1, column - 1));
        if(row - 1 >= 0 && column + 1 < 8) possibleMoves.add(GameManager.getSquareAt(row - 1, column + 1));
        if(row + 1 < 8 && column + 1 < 8) possibleMoves.add(GameManager.getSquareAt(row + 1, column + 1));
        if(row + 1 < 8 && column - 1 >= 0) possibleMoves.add(GameManager.getSquareAt(row + 1, column - 1));

        possibleMoves = getMoveHandler().verifyPossibleMoves(possibleMoves);
        possibleMoves.add(getLocation());

        return possibleMoves;
    }

    @Override
    public ArrayList<BoardSquare> getPossibleJumps() {

        ArrayList<BoardSquare> possibleJumps = new ArrayList<>();
        int row = getLocation().getRowIndex();
        int column = getLocation().getColumnIndex();

        if(row - 2 >= 0 && column - 2 >= 0) possibleJumps.add(GameManager.getSquareAt(row - 2, column - 2));
        if(row - 2 >= 0 && column + 2 < 8) possibleJumps.add(GameManager.getSquareAt(row - 2, column + 2));
        if(row + 2 < 8 && column + 2 < 8) possibleJumps.add(GameManager.getSquareAt(row + 2, column + 2));
        if(row + 2 < 8 && column - 2 >= 0) possibleJumps.add(GameManager.getSquareAt(row + 2, column - 2));

        possibleJumps = getMoveHandler().verifyPossibleJumps(possibleJumps, getLocation());
        possibleJumps.add(getLocation());

        return possibleJumps;
    }
}
