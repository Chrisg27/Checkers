package com.example.checkers.IndependentActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.R;
import com.example.checkers.Sounds.BackgroundMusic;
import com.example.checkers.Sounds.BackgroundMusicManager;

public class StartupScreen extends AppCompatActivity {

    BackgroundMusic backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);
        GameManager.setApplicationContext(getApplicationContext());
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

    public void goToOfflineGameSelectScreen(View view){
        Intent intent = new Intent(this, OfflineGameSelectScreen.class);
        startActivity(intent);
    }
}