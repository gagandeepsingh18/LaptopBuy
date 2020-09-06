package com.example.laptopbuy;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

import com.example.laptopbuy.ui.AskmeActivity;

public class FaqActivity extends AppCompatActivity {



    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq);

    }
    public void AskMe(View view){
        Intent intent= new Intent(this, AskmeActivity.class);
        startActivity(intent);
    }public void AboutUs(View view){
        Intent intent=new Intent(this,AboutusActivity.class);
        startActivity(intent);
    }
}