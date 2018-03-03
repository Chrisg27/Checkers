package com.example.checkers.GameTypes;

import com.example.checkers.GameComponents.BoardSquare;
import com.example.checkers.GameComponents.BoardSquareManager;
import com.example.checkers.GameComponents.UIManager;
import com.example.checkers.GamePieceComponents.GamePiece;
import com.example.checkers.Player.Player;
import com.example.checkers.Player.Player1;
import com.example.checkers.Player.Player2;
import java.io.Serializable;

public abstract class GeneralGame implements Serializable {

    private Player1 player1;
    private Player2 player2;
    private Player currentTurn;
    private boolean isFirstInput = true;
    private boolean isPostJumpMove = false;
    private String fileName;

    private transient BoardSquare firstInput = null;
    private transient BoardSquare secondInput = null;

    public String getFileName(){return fileName;}
    public void setFileName(String name){fileName = name;}
    public Player1 getPlayer1(){
        return player1;
    }
    public void setPlayer1(Player1 player){player1 = player;}
    public Player2 getPlayer2(){
        return player2;
    }
    public void setPlayer2(Player2 player){player2 = player;}
    public boolean isFirstInput(){
        return isFirstInput;
    }
    public void switchTurns(){
        currentTurn = (currentTurn == player1) ? player2 : player1;
    }
    public Player getCurrentTurn(){
        return currentTurn;
    }
    public void setCurrentTurn(Player player){currentTurn = player;}

    public abstract void newGame();
    public abstract void loadGame();
    public abstract void checkForWinner();

    public void handleInput(BoardSquare square){

        //checks to see if the same piece was toggled off
        if(firstInput == square){

            //checks to see if extra after jump jumps option was canceled by deselecting the piece
            if(isPostJumpMove) postMove();
            else{
                isFirstInput = true;
                firstInput = null;
                UIManager.resetBoard();
            }

        }  else if(isFirstInput) {
            if (checkFirstSquareInput(square)) {
                isFirstInput = false;
                firstInput = square;

                UIManager.blockInput();
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
        UIManager.showMoves(piece.getPossibleMoves());
    }

    public void showPossibleJumpsFor(GamePiece piece){
        UIManager.showMoves(piece.getPossibleJumps());
    }

    public void completeMove(){
        GamePiece piece = currentTurn.getPieceAtLocation(firstInput);
        currentTurn.movePieceTo(piece, secondInput);
        postMove();
    }

    public void completeJump(){
        BoardSquare jumpedSquare = currentTurn.getPieceAtLocation(firstInput).getJumpedSquareFor(secondInput);
        Player otherPlayer = getOtherPlayer();
        GamePiece jumpedPiece = otherPlayer.getPieceAtLocation(jumpedSquare);
        otherPlayer.removePiece(jumpedPiece);
        otherPlayer.decreasePieceCount();
        GamePiece piece = currentTurn.getPieceAtLocation(firstInput);
        currentTurn.movePieceTo(piece, secondInput);

        if(checkForMoreJumps()){
            UIManager.resetBoard();
            firstInput.highlight();
            isPostJumpMove = true;
            UIManager.blockInput();
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

    public void postMove(){
        firstInput = null;
        secondInput = null;
        isFirstInput = true;
        isPostJumpMove = false;
        BoardSquareManager.resetBoard();
        checkForKings();
        checkForWinner();
    }
}