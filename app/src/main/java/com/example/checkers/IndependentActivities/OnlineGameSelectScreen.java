package com.example.checkers.IndependentActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.checkers.R;
import com.example.checkers.Sounds.BackgroundMusic;
import com.example.checkers.Sounds.BackgroundMusicManager;

public class OnlineGameSelectScreen extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_game_select_screen);
        backgroundMusic = BackgroundMusicManager.getBackgroundMusic();
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
    }
}
