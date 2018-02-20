package com.example.checkers.Sounds;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.checkers.R;

import java.io.IOException;

public class PlacePieceSound extends Sound {

    public PlacePieceSound(Context context){
        super(context);
    }

    @Override
    public void play() {
        player = MediaPlayer.create(getContext(), R.raw.placepiece);
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
