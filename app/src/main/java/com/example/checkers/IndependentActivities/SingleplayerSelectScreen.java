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

public class SingleplayerSelectScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer_select_screen);
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
