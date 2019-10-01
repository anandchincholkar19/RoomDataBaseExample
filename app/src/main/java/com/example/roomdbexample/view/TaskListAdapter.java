package com.example.roomdbexample.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdbexample.R;
import com.example.roomdbexample.entity.Task;

import java.util.List;

public class TaskListAdapter extends
        RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>{

    private List<Task>mTaskList;
    private Context  mContext;

    public TaskListAdapter(List<Task> taskList, Context context ) {
        this.mTaskList = taskList;
        this.mContext = context;
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
        myViewHolder.txtTaskTimeLine.setText(String.valueOf(task.getTaskTimeLine())+mContext.getString(R.string.txt_hr));
        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }

    protected class TaskListViewHolder extends RecyclerView.ViewHolder {
        TextView txtTaskName;
        TextView txtTaskDescription;
        TextView txtTaskTimeLine;
        TextView txtTaskPriorty;

        private TaskListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTaskName = itemView.findViewById(R.id.txt_task_name);
            txtTaskDescription = itemView.findViewById(R.id.txt_task_desc);
            txtTaskTimeLine = itemView.findViewById(R.id.txt_task_timeline);
            txtTaskPriorty = itemView.findViewById(R.id.txt_task_prioty);
        }
    }
}
