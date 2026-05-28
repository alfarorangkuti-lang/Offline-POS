package com.example.practinepos.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {ItemEntity.class},
        version = 1
)

public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
    private static AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context){
     if (INSTANCE == null){
         INSTANCE = Room.databaseBuilder(
                 context.getApplicationContext(),
                 AppDatabase.class,
                 "pos_db"
         ).allowMainThreadQueries().build();
     }
     return INSTANCE;
    }
}
