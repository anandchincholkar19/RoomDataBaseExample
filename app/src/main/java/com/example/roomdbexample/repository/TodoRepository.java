package com.example.roomdbexample.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.roomdbexample.dao.TaskDao;
import com.example.roomdbexample.entity.Task;

import java.util.List;

public class TodoRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> taskList;

    public TodoRepository(Application application) {
        TodoRoomDatabase todoRoomDatabase = TodoRoomDatabase.getDatabase(application);
        taskDao = todoRoomDatabase.taskDao();
        taskList = taskDao.getAllTask();
    }

    public LiveData<List<Task>> getTaskList() {
        return taskList;
    }

    public void insert(Task task) {
        new insertAsyncTask(taskDao, task).execute(task);
    }

    private static class insertAsyncTask extends AsyncTask<Task, Void, Void> {
        private TaskDao mAsyncTaskDao;
        private Task mTask;
        insertAsyncTask(TaskDao taskDao, Task task) {
            mAsyncTaskDao = taskDao;
            mTask = task;
        }

        @Override
        protected Void doInBackground(final Task... tasks) {
            mAsyncTaskDao.insertTask(mTask);
            Log.e("Item_Added", "called");

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}

