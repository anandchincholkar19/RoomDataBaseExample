package com.example.roomdbexample.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.roomdbexample.dao.TaskDao;
import com.example.roomdbexample.entity.Task;

@Database(entities = {Task.class} ,version = 1)
public abstract class TodoRoomDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();
    private static volatile TodoRoomDatabase INSTANCE;

    static TodoRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TodoRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder
                            (context.getApplicationContext(),
                                    TodoRoomDatabase.class, "task").build();
                }
            }
        }
        return INSTANCE;
    }


}
