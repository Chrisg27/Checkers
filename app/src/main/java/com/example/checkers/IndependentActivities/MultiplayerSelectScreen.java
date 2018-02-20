package com.example.checkers.IndependentActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.checkers.R;
import com.example.checkers.Sounds.BackgroundMusic;
import com.example.checkers.Sounds.BackgroundMusicManager;

public class MultiplayerSelectScreen extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_select_screen);
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
}
