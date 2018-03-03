package com.example.checkers.GameComponents;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.checkers.R;
import com.example.checkers.Sounds.BackgroundMusic;
import com.example.checkers.Sounds.BackgroundMusicManager;

public class BoardDisplay extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_display);

        backgroundMusic = BackgroundMusicManager.getBackgroundMusic();

        GameManager.setDisplay(this);

        //Start game after the whole activity has been set up
        findViewById(R.id.parent_window).post(new Runnable() {
            @Override
            public void run() {
                fitBoardOnScreen();

                if(GameManager.isSavedGame()) GameManager.startSavedGame();
                else GameManager.startNewGame();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        backgroundMusic.play();
    }

    @Override
    protected void onPause(){
        super.onPause();
        backgroundMusic.pause();
        if(isFinishing() && !GameManager.isDeletedGame()) GameManager.saveGame();
        GameManager.setIsDeletedGame(false);
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    public void onClick(View view){

        BoardSquare square = (BoardSquare) view;
        square.toggle();
        GameManager.passInput(square);
    }

    private void fitBoardOnScreen(){

        ConstraintLayout parentWindow = findViewById(R.id.parent_window);
        int screenWidth = parentWindow.getWidth();
        int buttonWidth = screenWidth/8;

        for(int rowIndex = 0; rowIndex <= 7; rowIndex++){
            for(int columnIndex = 0; columnIndex <= 7; columnIndex++){
                BoardSquare square = BoardSquareManager.getSquareAt(rowIndex, columnIndex);
                square.adjustSize(buttonWidth);
            }
        }
    }
}