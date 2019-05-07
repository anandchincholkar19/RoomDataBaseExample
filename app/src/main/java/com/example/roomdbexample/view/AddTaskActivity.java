package com.example.roomdbexample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdbexample.R;
import com.example.roomdbexample.entity.Task;
import com.example.roomdbexample.viewmodel.TodoViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private TodoViewModel todoViewModel;
    private EditText edtTaskName, edtTaskDescrption, edtTaskTimeLine, edtTaskRemark;
    private Spinner spinnerPriorty;

    private Button btnSave, btnClear;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setAddTaskLayout();


    }

    private void setAddTaskLayout() {
        edtTaskName = findViewById(R.id.edit_task_name);
        edtTaskDescrption = findViewById(R.id.edt_task_desc);
        edtTaskRemark = findViewById(R.id.edit_task_remark);
        edtTaskTimeLine = findViewById(R.id.edt_task_timeline);
        spinnerPriorty = findViewById(R.id.spinner);
        btnSave = findViewById(R.id.btn_save);
        btnClear = findViewById(R.id.btn_clear);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        btnClear.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel.class);
        task = new Task();
        List<String> list = new ArrayList<String>();
        list.add("High");
        list.add("Low");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriorty.setAdapter(dataAdapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                addTask();
            case R.id.btn_clear:
                clearTaskScreen();
        }

    }

    private void clearTaskScreen() {

        edtTaskName.getText().clear();
        edtTaskRemark.getText().clear();
        edtTaskDescrption.getText().clear();
        edtTaskTimeLine.getText().clear();
    }

    private void addTask() {

        if (!(TextUtils.isEmpty(edtTaskName.getText()) && TextUtils.isEmpty(edtTaskDescrption.getText()) && TextUtils.isEmpty(edtTaskRemark.getText()) && TextUtils.isEmpty(edtTaskTimeLine.getText()))) {
            task.setTaskName(edtTaskName.getText().toString());
            task.setTaskNamedesc(edtTaskDescrption.getText().toString());
            task.setTaskPriority((String) spinnerPriorty.getSelectedItem());
            task.setTaskRemarks(edtTaskRemark.getText().toString());
            task.setTaskTimeLine(Integer.parseInt(edtTaskTimeLine.getText().toString()));
            todoViewModel.insertTask(task);
            clearTaskScreen();

        } else {
            Toast.makeText(this, "Please enter all fields ", Toast.LENGTH_SHORT).show();
        }


    }

    private void navigateTaskListScreen() {

        Intent taskListIntent = new Intent(this, TaskListActivity.class);
        startActivity(taskListIntent);
    }
}
