package com.example.administrator.mobileshophehaolin.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.administrator.mobileshophehaolin.R;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}