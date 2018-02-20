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

    public void goToSingleplayerSelectScreen(View view){
        Intent intent = new Intent(this, SingleplayerSelectScreen.class);
        startActivity(intent);
    }
}
