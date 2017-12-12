package com.example.checkers;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;

public class BoardDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_display);

        //waits for layout to be drawn before adjusting square size
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fixBoardSize();
            }
        }, 100);
    }

    private void fixBoardSize(){

        ConstraintLayout parentWindow = findViewById(R.id.parent_window);
        int screenWidth = parentWindow.getWidth();
        int buttonWidth = screenWidth/8;

        //updates all the buttons
        BoardSquare square;

        square = findViewById(R.id.boardsquare_1_1);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_1_2);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_1_3);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_1_4);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_1_5);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_1_6);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_1_7);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_1_8);
        square.adjustSize(buttonWidth);

        square = findViewById(R.id.boardsquare_2_1);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_2_2);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_2_3);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_2_4);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_2_5);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_2_6);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_2_7);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_2_8);
        square.adjustSize(buttonWidth);

        square = findViewById(R.id.boardsquare_3_1);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_3_2);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_3_3);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_3_4);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_3_5);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_3_6);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_3_7);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_3_8);
        square.adjustSize(buttonWidth);

        square = findViewById(R.id.boardsquare_4_1);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_4_2);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_4_3);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_4_4);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_4_5);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_4_6);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_4_7);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_4_8);
        square.adjustSize(buttonWidth);

        square = findViewById(R.id.boardsquare_5_1);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_5_2);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_5_3);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_5_4);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_5_5);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_5_6);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_5_7);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_5_8);
        square.adjustSize(buttonWidth);

        square = findViewById(R.id.boardsquare_6_1);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_6_2);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_6_3);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_6_4);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_6_5);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_6_6);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_6_7);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_6_8);
        square.adjustSize(buttonWidth);

        square = findViewById(R.id.boardsquare_7_1);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_7_2);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_7_3);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_7_4);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_7_5);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_7_6);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_7_7);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_7_8);
        square.adjustSize(buttonWidth);

        square = findViewById(R.id.boardsquare_8_1);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_8_2);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_8_3);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_8_4);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_8_5);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_8_6);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_8_7);
        square.adjustSize(buttonWidth);
        square = findViewById(R.id.boardsquare_8_8);
        square.adjustSize(buttonWidth);
    }
}
