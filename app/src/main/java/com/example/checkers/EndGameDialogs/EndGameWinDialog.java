package com.example.checkers.EndGameDialogs;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import com.example.checkers.GameComponents.BoardSquareManager;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.Player.Player;
import com.example.checkers.R;
import com.example.checkers.Sounds.GameVictorySound;
import com.example.checkers.Sounds.Sound;

public class EndGameWinDialog extends EndGameDialog{

    public EndGameWinDialog(Player messageReciever, Context context){
        super(messageReciever, context);
    }

    @Override
    public void setMessage(){
        getBuilder().setMessage("Congrats, " + getMessageReciever().toString() + ", you have won!");
    }

    @Override
    public void createButtons(){
        getBuilder().setPositiveButton(R.string.rematch, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                GameManager.restartGame();
                ((Activity) getContext()).finish();
            }
        });

        getBuilder().setNegativeButton(R.string.menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((Activity) getContext()).finish();
            }
        });
    }

    @Override
    public void playSound(){
        Sound sound = new GameVictorySound(getContext());
        sound.play();
    }
}
