package com.example.felix_its.synthesis.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.felix_its.synthesis.Adapter.TaskAdapter;
import com.example.felix_its.synthesis.DBHelper.DBhelper;
import com.example.felix_its.synthesis.DBHelper.Task;
import com.example.felix_its.synthesis.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {
    RecyclerView rvUsers;


    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);

        rvUsers=view.findViewById( R.id.rvUsers );

        rvUsers.setLayoutManager( new LinearLayoutManager( getActivity() ) );

        DBhelper dbholder=new DBhelper( getActivity() );

        List<Task> tasks=dbholder.getAllTask();

        TaskAdapter adapter=new TaskAdapter(tasks ,dbholder );
        rvUsers.setAdapter( adapter );
        // Inflate the layout for this fragment
        return view;
    }

}
