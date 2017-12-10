package com.example.checkers.IndependentActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.checkers.BoardDisplay;
import com.example.checkers.Game;
import com.example.checkers.R;

public class SingleplayerSelectScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_select_screen);
    }

    public void startPassAndPlayGame(View view){
        new Game(Game.GameType.PASSANDPLAY);
        Intent intent = new Intent(this, BoardDisplay.class);
        startActivity(intent);
    }

    public void startAIGame(View view){
        new Game(Game.GameType.AI);
        Intent intent = new Intent(this, BoardDisplay.class);
        startActivity(intent);
    }
}
