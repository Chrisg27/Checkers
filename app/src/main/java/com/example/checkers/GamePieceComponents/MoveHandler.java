package com.example.checkers.GamePieceComponents;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.BoardSquareManager;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.Player.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class MoveHandler{

    public ArrayList<BoardSquare> verifyPossibleMoves(ArrayList<BoardSquare> possibleMoves){

        ArrayList<BoardSquare> verifiedSquares = new ArrayList<>();

        for(BoardSquare square : possibleMoves){
            if(square.hasPiece()) continue;
            else verifiedSquares.add(square);

        } return verifiedSquares;
    }

    //gets the vertical direction the jumped square is from the start
    public int getRowFactor(BoardSquare start, BoardSquare end){

        int rowDifference = start.getRowIndex() - end.getRowIndex();

        if(rowDifference > 0) return rowDifference - 1;
        else return rowDifference + 1;
    }

    //gets the horizontal direction the jumped square is from the start
    public int getColumnFactor(BoardSquare start, BoardSquare end){

        int columnDifference = start.getColumnIndex() - end.getColumnIndex();

        if(columnDifference > 0) return columnDifference - 1;
        else return columnDifference + 1;
    }

    public BoardSquare getJumpedSquare(BoardSquare currentSquare, BoardSquare newLocation){
        int startRow = currentSquare.getRowIndex();
        int startColumn = currentSquare.getColumnIndex();
        return BoardSquareManager.getSquareAt(startRow - getRowFactor(currentSquare, newLocation), startColumn - getColumnFactor(currentSquare, newLocation));
    }

    public ArrayList<BoardSquare> verifyPossibleJumps(ArrayList<BoardSquare> possibleJumps, BoardSquare currentSquare){

        ArrayList<BoardSquare> verifiedSquares = new ArrayList<>();
        Player currentTurn = GameManager.getCurrentTurn();

        for(BoardSquare possibleJump : possibleJumps){

            BoardSquare jumpedSquare = getJumpedSquare(currentSquare, possibleJump);
            if(!possibleJump.hasPiece() && jumpedSquare.hasPiece()&& !currentTurn.doesPieceHaveLocation(jumpedSquare)) verifiedSquares.add(possibleJump);
        }

        return verifiedSquares;
    }
}