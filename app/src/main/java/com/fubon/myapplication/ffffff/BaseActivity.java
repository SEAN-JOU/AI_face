package com.fubon.myapplication.ffffff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fubon.myapplication.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
