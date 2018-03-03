package com.example.checkers.GameComponents;

import android.content.Context;
import android.content.Intent;
import com.example.checkers.GameTypes.GeneralGame;
import com.example.checkers.Player.Player;

public class GameManager {

    private static MainGameLoop gameLoop;
    private static BoardDisplay activityView;
    private static Context applicationContext;
    private static boolean isDeletedGame;
    private static boolean isSavedGame;

    public static void setUpGame(GeneralGame gameType){
        gameLoop = new MainGameLoop(gameType);
    }

    public static void startNewGame(){
        gameLoop.startNewGame();
    }

    public static void startSavedGame(){
        gameLoop.startSavedGame();
        isSavedGame = false;
    }

    public static void loadGame(GeneralGame game){
        isSavedGame = true;
        setUpGame(game);
    }

    public static boolean isSavedGame(){
        return isSavedGame;
    }

    public static boolean isDeletedGame(){return isDeletedGame;}

    public static void setIsDeletedGame(boolean state){isDeletedGame = state;}

    public static void setApplicationContext(Context context){
        applicationContext = context;
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
        IODataManager.save(gameLoop.getGame(), gameLoop.getGame().getFileName(), applicationContext);
    }

    public static void restartGame(){
        BoardSquareManager.setNewGameBoard();
        isDeletedGame = false;
        setUpGame(gameLoop.getGame());
        Intent intent = new Intent(applicationContext, BoardDisplay.class);
        applicationContext.startActivity(intent);
    }

    public static void endGame(String fileName){
        BoardSquareManager.setNewGameBoard();
        isDeletedGame = true;
        IODataManager.delete(fileName, applicationContext);
    }
}