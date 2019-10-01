package com.example.roomdbexample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.roomdbexample.R;
import com.example.roomdbexample.entity.Task;
import com.example.roomdbexample.viewmodel.TodoViewModel;

import java.util.List;

public class TaskListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView taskRecylerView;
    private TaskListAdapter taskListAdapter;
    private TodoViewModel todoViewModel;
    private FloatingActionButton fabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        setTaskListScreen();
        setTaskList();
    }

    private void setTaskList() {
        taskRecylerView = findViewById(R.id.recyler_task_list);
        fabButton = findViewById(R.id.floatingActionButton);
        fabButton.setOnClickListener(this);
        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel.class);
        prepareRecyleView();
    }

    private void prepareRecyleView() {
        todoViewModel.getTaskList().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {
                if (tasks.size() != 0) {
                    findViewById(R.id.text_message).setVisibility(View.GONE);
                    taskListAdapter = new TaskListAdapter(tasks, TaskListActivity.this);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    taskRecylerView.setLayoutManager(mLayoutManager);
                    taskRecylerView.setItemAnimator(new DefaultItemAnimator());
                    taskRecylerView.setAdapter(taskListAdapter);
                } else {
                    findViewById(R.id.text_message).setVisibility(View.VISIBLE);
                }
            }
        });

    }


    private void setTaskListScreen() {
        taskRecylerView = findViewById(R.id.recyler_task_list);
    }

    @Override
    public void onClick(View v) {
        Intent addTaskIntent = new Intent(this, AddTaskActivity.class);
        startActivity(addTaskIntent);
    }

}
