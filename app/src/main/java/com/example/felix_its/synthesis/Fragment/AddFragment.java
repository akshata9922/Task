package com.example.felix_its.synthesis.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.felix_its.synthesis.DBHelper.DBhelper;
import com.example.felix_its.synthesis.DBHelper.Task;
import com.example.felix_its.synthesis.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {
    EditText edtname;
    Spinner spnselectapp,spnselectroom;
    Button btnsave;
    TimePicker simpleTimePicker;
    String[]appliance={"A.C","TV","Light","Fan"};
    String[] room={"Bedrrom","Living Room","Dining Room","Kitchen"};


    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        edtname=view.findViewById(R.id.edtname);
        spnselectapp=view.findViewById(R.id.spnselectapp);
        spnselectroom=view.findViewById(R.id.spnselectroom);
        btnsave=view.findViewById(R.id.btnsave);

        ArrayAdapter<String> applianceAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line ,  appliance);
        spnselectapp.setAdapter(applianceAdapter);
        ArrayAdapter<String> roomAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line ,  room);
        spnselectroom.setAdapter(roomAdapter);

        simpleTimePicker = view.findViewById(R.id.simpleTimePicker);
        simpleTimePicker.setIs24HourView(false);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =edtname.getText().toString().trim();
                String appliance =spnselectapp.getSelectedItem().toString().trim();
                String room =spnselectroom.getSelectedItem().toString().trim();
                String time =simpleTimePicker.getDisplay().toString().trim();

                Task task=new Task( name,appliance,room ,time);
                DBhelper dBholder=new DBhelper( getActivity() );
                boolean isAddes= dBholder.addTask( task );
                if(isAddes){
                    Toast.makeText( getActivity(),"Recod Added",Toast.LENGTH_SHORT ).show();

                }



            }
        });

        return view;







    }



}
