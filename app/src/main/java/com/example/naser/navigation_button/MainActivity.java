package com.example.naser.navigation_button;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_nav);
        navigation.setOnNavigationItemSelectedListener(this);
        onNavigationButtonSelected(R.id.navigation_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        onNavigationButtonSelected(item.getItemId());

        return true;
    }

    public void onNavigationButtonSelected(int itemId) {
        fragment = null;

        switch (itemId) {
            case R.id.navigation_home:
                fragment = new Fragment_1();
                break;

            case R.id.navigation_dashboard:
                fragment = new Fragment_2();
                break;
            case R.id.navigation_notifications:
                fragment = new Fragment_3();
                break;

            default: break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

    }

}

