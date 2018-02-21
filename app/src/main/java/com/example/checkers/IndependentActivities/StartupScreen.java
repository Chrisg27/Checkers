package com.example.checkers.IndependentActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.checkers.R;
import com.example.checkers.Sounds.BackgroundMusic;
import com.example.checkers.Sounds.BackgroundMusicManager;
import com.example.checkers.Sounds.Sound;

public class StartupScreen extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);
        backgroundMusic = new BackgroundMusic(this);
        BackgroundMusicManager.setBackgroundMusic(backgroundMusic);
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

    @Override
    protected void onDestroy(){
        super.onDestroy();
        backgroundMusic.stop();
    }

    public void goToSingleplayerSelectScreen(View view){
        Intent intent = new Intent(this, SingleplayerSelectScreen.class);
        startActivity(intent);
    }
}