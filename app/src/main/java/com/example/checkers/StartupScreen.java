package com.example.checkers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartupScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);
    }

    public void goToSingleplayerSelectScreen(View view){
        Intent intent = new Intent(this, SingleplayerSelectScreen.class);
        startActivity(intent);
    }
}
