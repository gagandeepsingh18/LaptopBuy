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
    Button Btn=findViewById(R.id.proceeding);
    private EditText editTextAddress;
    private EditText editTextZipCode;
    private EditText editTextCity;
    private EditText editTextProvince;

    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adressdelievery);
        db = FirebaseFirestore.getInstance();
        editTextAddress = findViewById(R.id.buildingadress);
        editTextZipCode = findViewById(R.id.zipcode);
        editTextCity = findViewById(R.id.city);
        editTextProvince = findViewById(R.id.provine);


        }


    public void saveAddress(View view) {




                String Address = editTextAddress.getText().toString().trim();
                String ZipCode = editTextZipCode.getText().toString().trim();
                String City = editTextCity.getText().toString().trim();
                String Province = editTextProvince.getText().toString().trim();

        Map<String,Object> map=new HashMap<>();
        map.put("address",Address);
        map.put("zipCode",ZipCode);
        map.put("city",City);
        map.put("provice",Province);

                db.collection("Cart")
                        .document("Cart").set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

                Intent TNT=new Intent(AdressDelievery_Activity.this, PaymentDetails_Activity.class);
                startActivity(TNT);
                finish();

            }

    }

