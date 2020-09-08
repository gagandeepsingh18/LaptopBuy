package com.example.laptopbuy;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutusActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        Intent intent=getIntent();
        startActivity(intent);
//Here, About us activity is being started by getIntent() function.
        mTextView = (TextView) findViewById(R.id.text);


    }
}