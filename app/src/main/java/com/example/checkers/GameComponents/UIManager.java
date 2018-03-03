package com.example.checkers.GameComponents;

import android.content.Context;

import com.example.checkers.EndGameDialogs.EndGameLossDialog;
import com.example.checkers.EndGameDialogs.EndGameWinDialog;
import com.example.checkers.Player.Player;
import java.util.ArrayList;

public class UIManager {

    public static void acceptInput(){
        BoardSquareManager.freeBoardSquares();
    }

    public static void blockInput(){
        BoardSquareManager.lockBoardSquares();
    }

    public static void showMoves(ArrayList<BoardSquare> squares){
        BoardSquareManager.freeOnly(squares);
        BoardSquareManager.highlightSquares(squares);
    }

    public static void resetBoard(){
        BoardSquareManager.resetBoard();
    }

    public static void showWinEndGameFor(Player player, Context context){
        new EndGameWinDialog(player, context);
    }

    public static void showLossEndGameFor(Player player, Context context){
        new EndGameLossDialog(player, context);

    }
}
