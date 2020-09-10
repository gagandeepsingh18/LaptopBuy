package com.example.laptopbuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AdressDelievery_Activity extends AppCompatActivity {
    Button Btn;
    private EditText editTextAddress;
    private EditText editTextZipCode;
    private EditText editTextCity;
    private EditText editTextProvince;
    String name,price;

    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adressdelievery);
        Btn=findViewById(R.id.proceeding);
        db = FirebaseFirestore.getInstance();
        editTextAddress = findViewById(R.id.buildingadress);
        editTextZipCode = findViewById(R.id.zipcode);
        editTextCity = findViewById(R.id.city);
        editTextProvince = findViewById(R.id.provine);
       name=getIntent().getStringExtra("name");
        price=getIntent().getStringExtra("price");

Btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String Address = editTextAddress.getText().toString().trim();
        String ZipCode = editTextZipCode.getText().toString().trim();
        String City = editTextCity.getText().toString().trim();
        String Province = editTextProvince.getText().toString().trim();




        Intent TNT=new Intent(AdressDelievery_Activity.this, PaymentDetails_Activity.class);
        TNT.putExtra("name",name);
        TNT.putExtra("price",price);
        TNT.putExtra("adress",Address);
        TNT.putExtra("zipcode",ZipCode);
        TNT.putExtra("city",City);
        TNT.putExtra("province",Province);
        startActivity(TNT);
        finish();
    }
});
        }


    }

