package com.example.checkers.EndGameDialogs;

import android.app.AlertDialog;
import android.content.Context;
import com.example.checkers.Player.Player;

public abstract class EndGameDialog {

    private Player messageReciever;
    private Context context;
    private AlertDialog.Builder builder;

    public EndGameDialog(Player messageReciever, Context context){
        this.messageReciever = messageReciever;
        this.context = context;
        builder = new AlertDialog.Builder(context);
        builder.setTitle("Game Over!");
        setMessage();
        createButtons();
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        playSound();
    }

    public abstract void setMessage();
    public abstract void createButtons();
    public abstract void playSound();

    public Player getMessageReciever(){return messageReciever;}
    public Context getContext(){return context;}
    public AlertDialog.Builder getBuilder(){return builder;}
}
