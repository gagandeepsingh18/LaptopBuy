package com.example.laptopbuy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laptopbuy.R;

public class AskmeActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.askme);
        Intent intent=getIntent();

        mTextView = (TextView) findViewById(R.id.text);


    }
}