package com.example.roomdbexample.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdbexample.R;

import com.example.roomdbexample.callback.OnLongClickListner;
import com.example.roomdbexample.entity.Task;

import java.util.List;

public class TaskListAdapter extends
        RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>{

    private List<Task>mTaskList;
    private Context  mContext;
    private OnLongClickListner mListner;

    public TaskListAdapter(List<Task> taskList , Context context, OnLongClickListner listner ) {
        this.mTaskList = taskList;
        this.mContext = context;
        this.mListner = listner;


    }

    @NonNull
    @Override
    public TaskListAdapter.TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View layoutInflater = LayoutInflater.from(mContext).inflate(R.layout.task_cell,parent,false);
        return new TaskListViewHolder(layoutInflater);
    }




    @Override
    public void onBindViewHolder(@NonNull TaskListAdapter.TaskListViewHolder myViewHolder, int position) {

        Task task = mTaskList.get(position);
        myViewHolder.txtTaskName.setText(task.getTaskName());
        myViewHolder.txtTaskDescription.setText(task.getTaskNamedesc());
        myViewHolder.txtTaskPriorty.setText(task.getTaskPriority());
        myViewHolder.txtTaskTimeLine.setText("" +task.getTaskTimeLine());
        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mListner.onViewLongClick(v);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }

    public class TaskListViewHolder extends RecyclerView.ViewHolder {
        TextView txtTaskName, txtTaskDescription,txtTaskTimeLine , txtTaskPriorty;

        public TaskListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTaskName = itemView.findViewById(R.id.txt_task_name);
            txtTaskDescription = itemView.findViewById(R.id.txt_task_desc);
            txtTaskTimeLine = itemView.findViewById(R.id.txt_task_timeline);
            txtTaskPriorty = itemView.findViewById(R.id.txt_task_prioty);
        }
    }
}
