package com.example.checkers.GamePieceComponents;

import com.example.checkers.GameComponents.BoardSquare;
import java.util.ArrayList;

public interface MoveHandler {

    ArrayList<BoardSquare> verifyPossibleMoves(ArrayList<BoardSquare> possibleMoves);
    ArrayList<BoardSquare> verifyPossibleJumps(ArrayList<BoardSquare> possibleJumps);
}