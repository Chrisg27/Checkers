package com.example.checkers.GameComponents;

import android.content.Context;

import com.example.checkers.GameTypes.GeneralGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IODataManager {

    public static void save(Object object, String fileName, Context context){

        ObjectOutputStream outputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(object);

        } catch(IOException E) {
            E.printStackTrace();

        } finally {
            try{
                outputStream.close();
                fileOutputStream.close();

            } catch(Exception E){
                E.printStackTrace();
            }
        }
    }

    public static GeneralGame open(String fileName, Context context){

        GeneralGame openedObject = null;
        try{
            File file = context.getFileStreamPath(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            openedObject = (GeneralGame) objectInputStream.readObject();
            objectInputStream.close();

        } catch(IOException | ClassNotFoundException E){
            E.printStackTrace();

        } return openedObject;
    }

    public static void delete(String fileName, Context context){
        File file = context.getFileStreamPath(fileName);
        if(file.delete()) System.out.println("DELETED");
    }
}