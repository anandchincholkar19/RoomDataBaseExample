package com.example.roomdbexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.roomdbexample.entity.Task;
import com.example.roomdbexample.repository.TodoRepository;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {

    private TodoRepository todoRepository;
    private LiveData<List<Task>> taskList;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        todoRepository = new TodoRepository(application);
        taskList = todoRepository.getTaskList();
    }

    public LiveData<List<Task>> getTaskList() {
        return taskList;
    }

    public void insertTask(Task task) {
        todoRepository.insert(task);
    }
}
