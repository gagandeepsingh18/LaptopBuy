package com.example.laptopbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CartForm_Activity extends AppCompatActivity {
    Button profile, faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartform);
        Button BTN=findViewById(R.id.proceed);
        profile=findViewById(R.id.profile);
        faq=findViewById(R.id.faq);
        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tnt=new Intent(CartForm_Activity.this, AdressDelievery_Activity.class);
                startActivity(tnt);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFunction();
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FAQFunction();
            }
        });
    }

    private void ProfileFunction() {
        Intent intent = new Intent(CartForm_Activity.this, UserProfile.class);
        startActivity(intent);
    }

    private void FAQFunction() {
        Intent intent = new Intent(CartForm_Activity.this, FaqActivity.class);
        startActivity(intent);
    }
}