package com.example.checkers.GameComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Checkable;
import com.example.checkers.R;

import java.util.ArrayList;

public class BoardSquare extends AppCompatImageButton implements Checkable {

    private ArrayList<BoardSquare> possibleRedMoves = new ArrayList<BoardSquare>();
    private ArrayList<BoardSquare> possibleRedJumps = new ArrayList<BoardSquare>();
    private ArrayList<BoardSquare> possibleBlackMoves = new ArrayList<BoardSquare>();
    private ArrayList<BoardSquare> possibleBlackJumps = new ArrayList<BoardSquare>();

    //loaded from xml
    private boolean hasPiece;
    private boolean isPieceKing;
    private String pieceColor;
    //One less than its actual row and column numbers
    private int rowIndex;
    private int columnIndex;

    private GamePiece piece;
    private boolean isChecked;

    public BoardSquare(Context context){
        super(context);
    }

    public BoardSquare(Context context, AttributeSet attrs){
        super(context, attrs);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BoardSquare, 0, 0);

        pieceColor = attributes.getString(R.styleable.BoardSquare_pieceColor);
        hasPiece = attributes.getBoolean(R.styleable.BoardSquare_hasPiece, false);
        isPieceKing = attributes.getBoolean(R.styleable.BoardSquare_isPieceKing, false);
        rowIndex = attributes.getInteger(R.styleable.BoardSquare_rowIndex, 0);
        columnIndex = attributes.getInteger(R.styleable.BoardSquare_columnIndex, 0);
        attributes.recycle();

        setUp();
    }

    public BoardSquare(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BoardSquare, 0, 0);

        pieceColor = attributes.getString(R.styleable.BoardSquare_pieceColor);
        hasPiece = attributes.getBoolean(R.styleable.BoardSquare_hasPiece, false);
        isPieceKing = attributes.getBoolean(R.styleable.BoardSquare_isPieceKing, false);
        rowIndex = attributes.getInteger(R.styleable.BoardSquare_rowIndex, 0);
        columnIndex = attributes.getInteger(R.styleable.BoardSquare_columnIndex, 0);
        attributes.recycle();

        setUp();
    }

    @Override
    public boolean isChecked(){
        return isChecked;
    }

    @Override
    public void setChecked(boolean state){
        isChecked = state;
    }

    @Override
    public void toggle(){
        setChecked(!isChecked);
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getcolumnIndex(){
        return columnIndex;
    }

    private void setUp(){

        GameManager.setSquareAt(rowIndex, columnIndex, this);
        if(hasPiece) piece = new GamePiece(pieceColor, isPieceKing);
        setPossibleMoves();
    }

    public void adjustSize(int size){
        ViewGroup.LayoutParams params = getLayoutParams();
        params.width = size;
        params.height = size;
        setLayoutParams(params);
    }

    public void setPossibleMoves(){

        if(rowIndex - 1 >= 0 && columnIndex - 1 >= 0) possibleBlackMoves.add(GameManager.getSquareAt(rowIndex - 1, columnIndex - 1));
        if(rowIndex - 2 >= 0 && columnIndex - 2 >= 0) possibleBlackJumps.add(GameManager.getSquareAt(rowIndex - 2, columnIndex - 2));
        if(rowIndex - 1 >= 0 && columnIndex + 1 < 8) possibleBlackMoves.add(GameManager.getSquareAt(rowIndex - 1, columnIndex + 1));
        if(rowIndex - 2 >= 0 && columnIndex + 2 < 8) possibleBlackJumps.add(GameManager.getSquareAt(rowIndex - 2, columnIndex + 2));
        if(rowIndex + 1 < 8 && columnIndex + 1 < 8) possibleRedMoves.add(GameManager.getSquareAt(rowIndex + 1, columnIndex + 1));
        if(rowIndex + 2 < 8 && columnIndex + 2 < 8) possibleRedJumps.add(GameManager.getSquareAt(rowIndex + 2, columnIndex + 2));
        if(rowIndex + 1 < 8 && columnIndex - 1 >= 0) possibleRedMoves.add(GameManager.getSquareAt(rowIndex + 1, columnIndex - 1));
        if(rowIndex + 2 < 8 && columnIndex - 2 >= 0) possibleRedJumps.add(GameManager.getSquareAt(rowIndex + 2, columnIndex - 2));
    }

    public boolean checkIfPossibleMove(BoardSquare moveToSquare){

        if(piece.getColor().equals("red") || piece.isKing()){
            for(BoardSquare square : possibleRedMoves){
                if(square == moveToSquare) return true;
            }
        }

        else if(piece.getColor().equals("black") || piece.isKing()){
            for(BoardSquare square : possibleBlackMoves){
                if(square == moveToSquare) return true;
            }

        } return false;
    }

    public boolean checkIfPossibleJump(BoardSquare jumpToSquare){

        if(piece.getColor().equals("red") || piece.isKing()){
            for(BoardSquare square : possibleRedJumps){
                if(square == jumpToSquare) return true;
            }
        }

        else if(piece.getColor().equals("black") || piece.isKing()){
            for(BoardSquare square : possibleBlackJumps){
                if(square == jumpToSquare) return true;
            }

        } return false;
    }
}