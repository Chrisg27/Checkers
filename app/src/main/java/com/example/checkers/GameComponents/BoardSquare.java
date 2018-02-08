package com.example.checkers.GameComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Checkable;

import com.example.checkers.GamePieceComponents.GamePiece;
import com.example.checkers.R;

import java.util.ArrayList;

public class BoardSquare extends AppCompatImageButton implements Checkable {

    //One less than its actual row and column numbers
    //loaded in from XML
    private int rowIndex;
    private int columnIndex;

    private boolean isChecked;

    public BoardSquare(Context context){
        super(context);
    }

    public BoardSquare(Context context, AttributeSet attrs){
        super(context, attrs);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BoardSquare, 0, 0);

        rowIndex = attributes.getInteger(R.styleable.BoardSquare_rowIndex, 0);
        columnIndex = attributes.getInteger(R.styleable.BoardSquare_columnIndex, 0);
        attributes.recycle();

        addToBoardSquareArray();
    }

    public BoardSquare(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BoardSquare, 0, 0);

        rowIndex = attributes.getInteger(R.styleable.BoardSquare_rowIndex, 0);
        columnIndex = attributes.getInteger(R.styleable.BoardSquare_columnIndex, 0);
        attributes.recycle();

        addToBoardSquareArray();
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
    private void addToBoardSquareArray(){
        GameManager.setSquareAt(rowIndex, columnIndex, this);
    }

    public void adjustSize(int size){
        ViewGroup.LayoutParams params = getLayoutParams();
        params.width = size;
        params.height = size;
        setLayoutParams(params);
    }
}