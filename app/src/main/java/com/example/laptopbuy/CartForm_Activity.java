package com.example.laptopbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CartForm_Activity extends AppCompatActivity {
    Button BTN=findViewById(R.id.proceed);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_CartForm);
        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tnt=new Intent(CartForm_Activity.this, AdressDelievery_Activity.class);
                startActivity(tnt);
                finish();
            }
        });
    }
}