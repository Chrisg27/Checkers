package com.example.checkers.Sounds;

import android.content.Context;
import android.media.MediaPlayer;
import com.example.checkers.R;

public class GameVictorySound extends Sound {

    public GameVictorySound(Context context){
        super(context);
    }

    @Override
    public void play() {
        player = MediaPlayer.create(getContext(), R.raw.gamevictory);
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                player.start();
            }
        });
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stop();
            }
        });
    }

    @Override
    public void stop() {
        player.release();
    }
}
