package com.example.checkers.Sounds;

public class BackgroundMusicManager {

    static int currentPosition = 0;
    static BackgroundMusic backgroundMusic;

    public static int getCurrentPosition(){
        return currentPosition;
    }

    public static void setCurrentPosition(int position){
        currentPosition = position;
    }

    public static void setBackgroundMusic(BackgroundMusic music){
        backgroundMusic = music;
    }

    public static BackgroundMusic getBackgroundMusic(){
        return backgroundMusic;
    }

}
