package com.example.recyclerview.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.recyclerview.dao.AnimalDaoRoom;
import com.example.recyclerview.model.Animal;

@Database(entities = {Animal.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AnimalDaoRoom animalDaoRoom();

    //SINGLETON UNA UNICA INSTANCIA PARA TO DO

    private static AppDatabase INSTANCE = null;

    public static AppDatabase getInstance(Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "animales-db")
                    .allowMainThreadQueries()
                    .build();

//            INSTANCE = Room.inMemoryDatabaseBuilder(context,AppDatabase.class)
//                    .allowMainThreadQueries()
//                    .build();
        }

        return INSTANCE;
    }

}
