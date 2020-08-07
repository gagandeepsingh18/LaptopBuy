package com.example.laptopbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdressDelievery_Activity extends AppCompatActivity {
    Button Btn=findViewById(R.id.proceeding);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adressdelievery);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TNT=new Intent(AdressDelievery_Activity.this, PaymentDetails_Activity.class);
                startActivity(TNT);
                finish();
            }
        });

    }
}