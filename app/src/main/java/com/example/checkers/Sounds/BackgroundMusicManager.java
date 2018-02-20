package com.example.checkers.Sounds;

public class BackgroundMusicManager {

    static int currentPosition = 0;

    public static int getCurrentPosition(){
        return currentPosition;
    }

    public static void setCurrentPosition(int position){
        currentPosition = position;
    }

}
