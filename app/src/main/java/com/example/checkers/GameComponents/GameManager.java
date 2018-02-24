package com.example.checkers.GameComponents;

import com.example.checkers.GameTypes.GeneralGame;
import com.example.checkers.Player.Player;

import java.util.ArrayList;

public class GameManager {

    private static MainGameLoop gameLoop;
    private static BoardDisplay activityView;
    private static boolean isStartingLoadedGame;

    public static void setUpGame(GeneralGame gameType){
        gameLoop = new MainGameLoop(gameType);
    }

    public static void startNewGame(){
        gameLoop.startNewGame();
    }

    public static void startLoadedGame(){
        gameLoop.startLoadedGame();
        isStartingLoadedGame = false;
    }

    public static void loadGame(GeneralGame game){
        isStartingLoadedGame = true;
        setUpGame(game);
    }

    public static boolean isStartingLoadedGame(){
        return isStartingLoadedGame;
    }

    public static void setDisplay(BoardDisplay activity){
        activityView = activity;
    }

    public static BoardDisplay getDisplay(){
        return activityView;
    }

    public static Player getCurrentTurn(){
        return gameLoop.getCurrentTurn();
    }

    public static void passInput(BoardSquare square){
        gameLoop.passInput(square);
    }

    public static void saveGame(){
        IODataManager.save(gameLoop.getGame(), gameLoop.getGame().getFileName(), activityView.getApplicationContext());
    }

    public static void endGame(String fileName){
        activityView.finish();
        IODataManager.delete(fileName, activityView.getApplicationContext());
        activityView = null;
    }
}