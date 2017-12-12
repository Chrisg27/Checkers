package com.example.checkers;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

public class BoardSquare extends ToggleButton {

    //One less than its actual row and column numbers
    private int horizontalIndex;
    private int verticalIndex;

    public BoardSquare(Context context, AttributeSet attrs){
        super(context, attrs);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BoardSquare, 0, 0);

        horizontalIndex = attributes.getInteger(R.styleable.BoardSquare_horizontalIndex, 0);
        verticalIndex = attributes.getInteger(R.styleable.BoardSquare_verticalIndex, 0);
        attributes.recycle();
    }

    public BoardSquare(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.BoardSquare, 0, 0);

        horizontalIndex = attributes.getInteger(R.styleable.BoardSquare_horizontalIndex, 0);
        verticalIndex = attributes.getInteger(R.styleable.BoardSquare_verticalIndex, 0);
        attributes.recycle();
    }

    public int getHorizontalIndex() {
        return horizontalIndex;
    }

    public int getVerticalIndex(){
        return verticalIndex;
    }

    public void setHorizontalIndex(int index){
        horizontalIndex = index;
    }

    public void setVerticalIndex(int index){
        verticalIndex = index;
    }

    public void adjustSize(int size){
        ViewGroup.LayoutParams params = getLayoutParams();
        params.width = size;
        params.height = size;
        setLayoutParams(params);
    }
}