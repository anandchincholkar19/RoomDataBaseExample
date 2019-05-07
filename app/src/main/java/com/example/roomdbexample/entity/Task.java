package com.example.roomdbexample.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "task")
public class Task {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "taskId")
    private int taskId;
    @ColumnInfo(name = "taskName")
    private String taskName;
    @ColumnInfo(name = "taskNamedesc")
    private String taskNamedesc;
    @ColumnInfo(name = "taskTimeLine")
    private int  taskTimeLine;
    @ColumnInfo(name = "taskRemark")
    private String taskRemarks;
    @ColumnInfo(name = "taskPriority")
    private String taskPriority;

    public Task() {
    }

    public Task(@NonNull String taskName, String taskNamedesc, int taskTimeLine, String taskRemarks, String taskPriorty) {
        this.taskName = taskName;
        this.taskNamedesc = taskNamedesc;
        this.taskTimeLine = taskTimeLine;
        this.taskRemarks = taskRemarks;
        this.taskPriority = taskPriorty;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @NonNull
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(@NonNull String taskName) {
        this.taskName = taskName;
    }

    public String getTaskNamedesc() {
        return taskNamedesc;
    }

    public void setTaskNamedesc(String taskNamedesc) {
        this.taskNamedesc = taskNamedesc;
    }

    public int getTaskTimeLine() {
        return taskTimeLine;
    }

    public void setTaskTimeLine(int taskTimeLine) {
        this.taskTimeLine = taskTimeLine;
    }

    public String getTaskRemarks() {
        return taskRemarks;
    }

    public void setTaskRemarks(String taskRemarks) {
        this.taskRemarks = taskRemarks;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }



    @Override
    public String toString() {
        return  "taskname :" +taskName + "taskNamedesc : " + taskNamedesc +"taskprioty :" +taskPriority;
    }
}
