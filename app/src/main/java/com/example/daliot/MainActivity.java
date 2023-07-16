package com.example.daliot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new fragment_home());

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.home){

                loadFragment(new fragment_home());
                return true;
            } else if (item.getItemId() == R.id.dashboard) {

                loadFragment(new fragment_dashboard());
                return true;
            } else if (item.getItemId() == R.id.control) {

                loadFragment(new fragment_control());
                return true;
            } else if (item.getItemId() == R.id.about) {

                loadFragment(new fragment_about());
                return true;
            }else{

                return false;

            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
