package com.example.checkers;

//Will Handle each individual checkers game

import android.content.Intent;

import com.example.checkers.GameTypes.AIGame;
import com.example.checkers.GameTypes.MultiplayerGame;
import com.example.checkers.GameTypes.PassAndPlayGame;

public class Game {

    public enum GameType{
        MULTIPLAYER, PASSANDPLAY, AI
    }

    private CheckersGameOutline gameType;

    public Game(Game.GameType gameType){

        //Specifies Game Type
        switch(gameType) {
            case MULTIPLAYER: this.gameType = new MultiplayerGame();
            break;
            case PASSANDPLAY: this.gameType = new PassAndPlayGame();
            break;
            case AI: this.gameType = new AIGame();
            break;
        }
    }
}
