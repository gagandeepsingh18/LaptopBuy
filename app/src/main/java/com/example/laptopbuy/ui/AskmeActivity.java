package com.example.laptopbuy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laptopbuy.R;

public class AskmeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.askme);
        Intent intent = getIntent();
        startActivity(intent);
        // It is to open the page when the button is pressed. To Fetch the data of the page.

        mTextView = (TextView) findViewById(R.id.text);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
        // A view is created which will show a toast after pressing the Submit button.
                Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show();
            }
        }

