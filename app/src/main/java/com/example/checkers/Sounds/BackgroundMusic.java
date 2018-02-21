package com.example.checkers.Sounds;

import android.content.Context;
import android.media.MediaPlayer;
import com.example.checkers.R;

public class BackgroundMusic extends Sound {

    public BackgroundMusic(Context context){
        super(context);
        player = MediaPlayer.create(context, R.raw.bensoundlove);
        player.setLooping(true);
    }

    @Override
    public void play() {
        player.start();
    }

    @Override
    public void stop() {
        player.release();
    }

    public void pause(){
        player.pause();
    }
}