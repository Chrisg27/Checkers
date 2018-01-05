package com.example.checkers.GameComponents;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.checkers.R;

public class BoardDisplay extends AppCompatActivity {

    private static BoardDisplay currentInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_display);
        currentInstance = this;

        //waits for layout to be drawn before dynamically sizing boardSquares
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fitBoardOnScreen();
            }
        }, 100);
    }

    private void fitBoardOnScreen(){

        ConstraintLayout parentWindow = findViewById(R.id.parent_window);
        int screenWidth = parentWindow.getWidth();
        int buttonWidth = screenWidth/8;

        for(int rowIndex = 0; rowIndex <= 7; rowIndex++){
            for(int columnIndex = 0; columnIndex <= 7; columnIndex++){
                BoardSquare square = GameManager.getSquareAt(rowIndex, columnIndex);
                square.adjustSize(buttonWidth);
            }
        }
    }
}
