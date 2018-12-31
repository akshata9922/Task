package com.example.felix_its.synthesis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.felix_its.synthesis.Fragment.AddFragment;
import com.example.felix_its.synthesis.Fragment.UpdateFragment;
import com.example.felix_its.synthesis.Fragment.ViewFragment;

public class MainActivity extends AppCompatActivity {

    private TextView changeFragment;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_add:
                    changeFragment(new AddFragment());
                    return true;
                case R.id.navigation_view:
                    changeFragment(new ViewFragment());
                    return true;
                case R.id.navigation_update:
                    changeFragment(new UpdateFragment());
                    return true;

            }
            return false;
        }
    };


    public void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager( );
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction( );
        fragmentTransaction.replace(R.id.parent, fragment);
        fragmentTransaction.commit( );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        changeFragment(new AddFragment());
    }

}
