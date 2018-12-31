package com.example.felix_its.synthesis.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.felix_its.synthesis.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView txtsceduleName,txtroom,txtappliance,time;
    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);

        txtsceduleName=itemView.findViewById(R.id.txtsceduleName );
        txtroom=itemView.findViewById(R.id.txtroom );
        txtsceduleName=itemView.findViewById(R.id.txtappliance );
        time=itemView.findViewById(R.id.txtappliance);


    }
}
