package com.example.checkers.EndGameDialogs;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import com.example.checkers.GameComponents.BoardSquareManager;
import com.example.checkers.GameComponents.GameManager;
import com.example.checkers.Player.Player;
import com.example.checkers.R;
import com.example.checkers.Sounds.GameLossSound;
import com.example.checkers.Sounds.Sound;

public class EndGameLossDialog extends EndGameDialog {

    public EndGameLossDialog(Player messageReciever, Context context){
        super(messageReciever, context);
    }

    @Override
    public void setMessage() {
        getBuilder().setMessage("Sadly, " + getMessageReciever().toString() + ", you lost");
    }

    @Override
    public void createButtons() {
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
    public void playSound() {
        Sound sound = new GameLossSound(getContext());
        sound.play();
    }
}
