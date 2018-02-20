package com.example.checkers.IndependentActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.checkers.GameComponents.BoardDisplay;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.GameTypes.AIGame;
import com.example.checkers.GameTypes.PassAndPlayGame;
import com.example.checkers.R;
import com.example.checkers.Sounds.BackgroundMusic;
import com.example.checkers.Sounds.BackgroundMusicManager;

public class SingleplayerSelectScreen extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_select_screen);
    }

    @Override
    protected void onStart(){
        super.onStart();
        backgroundMusic = new BackgroundMusic(this, BackgroundMusicManager.getCurrentPosition());
        backgroundMusic.play();

    }

    @Override
    protected void onStop(){
        super.onStop();
        BackgroundMusicManager.setCurrentPosition(backgroundMusic.getCurrentPosition());
        backgroundMusic.stop();
    }

    public void startPassAndPlayGame(View view){
        Intent intent = new Intent(this, BoardDisplay.class);
        startActivity(intent);
        GameManager.setUpNewGame(new PassAndPlayGame());
    }

    public void startAIGame(View view){
        Intent intent = new Intent(this, BoardDisplay.class);
        startActivity(intent);
        GameManager.setUpNewGame(new AIGame());
    }
}
