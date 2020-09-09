package com.example.laptopbuy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.*;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laptopbuy.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class AskmeActivity extends AppCompatActivity {
    private static final String TAG = "AskmeActivity";
    private static final String KEY_MESSAGE = "Message";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_PHONE = "Phone";


    private TextView editTextMessage;
    private TextView editTextEmailAddress;
    private TextView editTextPhone;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.askme);
        Intent intent = getIntent();
        startActivity(intent);
        // It is to open the page when the button is pressed. To Fetch the data of the page.


        editTextMessage = findViewById(R.id.editTextMessage);
        editTextEmailAddress = findViewById(R.id.editEmail);
        editTextPhone = findViewById(R.id.editPhoneNumber);
    }

    public void saveNote(View v) {
        String message = editTextMessage.getText().toString();
        String email = editTextEmailAddress.getText().toString();
        String phone = editTextPhone.getText().toString();

        Map<String, Object> note = new HashMap<>();
        note.put(KEY_MESSAGE, message);
        note.put(KEY_EMAIL, email);
        note.put(KEY_PHONE, phone);
        db.collection("Feedback").document("Complaint").set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AskmeActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AskmeActivity.this, "Error! Please Try Again.", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });

    }
}

