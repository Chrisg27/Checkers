package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.GamePieceComponents.GamePiece;
import com.example.checkers.Player.Player;
import com.example.checkers.Player.Player1;
import com.example.checkers.Player.Player2;

import java.util.ArrayList;

public abstract class GeneralGame {

    private Player1 player1;
    private Player2 player2;
    private Player currentTurn;
    private BoardSquare firstInput = null;
    private BoardSquare secondInput = null;
    private boolean isFirstInput = true;
    private boolean isPostJumpMove = false;

    public Player1 getPlayer1(){
        return player1;
    }
    public Player2 getPlayer2(){
        return player2;
    }
    public boolean isFirstInput(){
        return isFirstInput;
    }
    public void switchTurns(){
        currentTurn = (currentTurn == player1) ? player2 : player1;
    }
    public Player getCurrentTurn(){
        return currentTurn;
    }

    public void newGame(){
        player1 = new Player1();
        player2 = new Player2();
        currentTurn = player1;
    }

    public void handleInput(BoardSquare square){

        //checks to see if the same piece was toggled off
        if(firstInput == square){

            //checks to see if extra after jump jumps option was canceled by deselecting the piece
            if(isPostJumpMove) postMove();
            else{
                isFirstInput = true;
                firstInput = null;
                GameManager.resetBoard();
            }

        }  else if(isFirstInput) {
            if (checkFirstSquareInput(square)) {
                isFirstInput = false;
                firstInput = square;

                GameManager.blockInput();
                showPossibleMovesFor(currentTurn.getPieceAtLocation(square));
                showPossibleJumpsFor(currentTurn.getPieceAtLocation(square));

            } else{
                square.unhighlight();
            }

        }  else{
            secondInput = square;
            if(firstInput.getColumnIndex() - square.getColumnIndex() == -2
                    || firstInput.getColumnIndex() - square.getColumnIndex() == 2) completeJump();
            else completeMove();
        }
    }

    public boolean checkFirstSquareInput(BoardSquare square){
        if(square.hasPiece() && currentTurn.doesPieceHaveLocation(square)){
            return true;

        } return false;
    }

    public void showPossibleMovesFor(GamePiece piece){
        GameManager.showMoves(piece.getPossibleMoves());
    }

    public void showPossibleJumpsFor(GamePiece piece){
        GameManager.showMoves(piece.getPossibleJumps());
    }

    public void completeMove(){
        GamePiece piece = currentTurn.getPieceAtLocation(firstInput);
        piece.moveTo(secondInput);
        postMove();
    }

    public void completeJump(){
        BoardSquare jumpedSquare = currentTurn.getPieceAtLocation(firstInput).getJumpedSquareFor(secondInput);
        Player otherPlayer = getOtherPlayer();
        GamePiece jumpedPiece = otherPlayer.getPieceAtLocation(jumpedSquare);
        otherPlayer.removePiece(jumpedPiece);
        otherPlayer.decreasePieceCount();
        GamePiece piece = currentTurn.getPieceAtLocation(firstInput);
        piece.moveTo(secondInput);

        if(checkForMoreJumps()){
            GameManager.resetBoard();
            firstInput.highlight();
            isPostJumpMove = true;
            showPossibleJumpsFor(piece);
        }
        else postMove();
    }

    public boolean checkForMoreJumps(){
        firstInput = secondInput;

        //checks the size of the possible jumps array
        if(currentTurn.getPieceAtLocation(firstInput).getPossibleJumps().size() > 1) return true;
        else return false;
    }

    public Player getOtherPlayer(){
        return (currentTurn == player1) ? player2 : player1;
    }

    public void checkForKings(){

        for(GamePiece piece : currentTurn.getPieces()){
            if(piece.getLocation().getRowIndex() == currentTurn.getKingRow()) currentTurn.kingPiece(piece);
        }
    }

    public void checkForWinner(){
        Player otherPlayer = getOtherPlayer();
        if(otherPlayer.getNumberOfPiecesLeft() == 0) GameManager.endGame();
    }

    public void postMove(){
        firstInput = null;
        secondInput = null;
        isFirstInput = true;
        isPostJumpMove = false;
        checkForKings();
        checkForWinner();
    }
}