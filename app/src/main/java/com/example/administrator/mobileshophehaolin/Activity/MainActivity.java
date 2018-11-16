package com.example.administrator.mobileshophehaolin.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.example.administrator.mobileshophehaolin.Fragment.NavigationFragment;
import com.example.administrator.mobileshophehaolin.R;

public class MainActivity extends BaseActivity {
    private NavigationFragment navigationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         navigationFragment = new NavigationFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_frame,navigationFragment).commit();
    }
}