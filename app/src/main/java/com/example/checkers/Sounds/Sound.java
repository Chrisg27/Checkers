package com.example.checkers.Sounds;

import android.content.Context;
import android.media.MediaPlayer;

public abstract class Sound {

    MediaPlayer player = new MediaPlayer();
    private Context context;

    public Sound(Context context){
        this.context = context;
    }

    public abstract void play();
    public abstract void stop();

    public Context getContext(){
        return context;
    }
}
