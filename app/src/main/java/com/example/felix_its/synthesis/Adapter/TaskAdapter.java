package com.example.felix_its.synthesis.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.example.felix_its.synthesis.DBHelper.DBhelper;
import com.example.felix_its.synthesis.DBHelper.Task;
import com.example.felix_its.synthesis.R;

import java.util.List;

public abstract class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    List<Task> tasks;
    DBhelper dbholder;
    public TaskAdapter(List<Task> tasks, DBhelper dbholder) {
        this.tasks = this.tasks;
        this.dbholder=dbholder;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.item_task_list,viewGroup,false  );
        return new TaskViewHolder( view );

    }

    @Override
    public void onBindViewHolder(@NonNull  TaskViewHolder holder, int i) {
        final Task task=tasks.get( i );
        holder .txtsceduleName.setText( "Name :"+ task.getName() );
        holder .txtroom.setText( "Room :"+ task.getRoom() );
        holder .txtappliance.setText( "Appliance :"+ task.getAppliance() );
        holder.time.setText("Time" +task.getTime() );


    }


    @Override
    public int getItemCount() {
        return tasks.size();
    }
    }

