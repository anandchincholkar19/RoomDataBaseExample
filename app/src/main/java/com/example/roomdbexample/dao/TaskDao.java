package com.example.roomdbexample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.roomdbexample.entity.Task;
import java.util.List;


@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Delete
    void deleteTask(Task task);

    @Query("SELECT * from task")
    LiveData<List<Task>> getAllTask();

    @Query("SELECT * from task where taskTimeLine<5")
    LiveData<List<Task>> getAllTaskByTimeLine();

    @Query("SELECT * from task where taskPriority Like 'HIGH' ")
    LiveData<List<Task>>getAllTaskByPriority();

}
