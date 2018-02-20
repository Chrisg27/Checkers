package com.example.checkers.Sounds;

import android.content.Context;
import android.media.MediaPlayer;
import com.example.checkers.R;

public class BackgroundMusic extends Sound {

    private int startingPosition;

    public BackgroundMusic(Context context, int startPosition){
        super(context);
        this.startingPosition = startPosition;
        player = MediaPlayer.create(context, R.raw.bensoundlove);
        player.setLooping(true);
    }

    @Override
    public void play() {
        player.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            @Override
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                player.start();
            }
        });
        player.seekTo(startingPosition);
    }

    @Override
    public void stop() {
        player.release();
    }

    public int getCurrentPosition(){
        return player.getCurrentPosition();
    }
}