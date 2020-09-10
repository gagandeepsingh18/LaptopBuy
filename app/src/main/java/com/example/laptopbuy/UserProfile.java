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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserProfile extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText phone;
    EditText address;
    Button button;
    String email2;
    private FirebaseFirestore cl=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent=getIntent();
        email2=intent.getStringExtra("emailIntent");

        name=(EditText) findViewById(R.id.editName);
        email=(EditText) findViewById(R.id.editEmail);
        phone=(EditText) findViewById(R.id.editPhoneNumber);
        address=(EditText) findViewById(R.id.editAddress);
        button=(Button) findViewById(R.id.buttonSave);



        cl.collection("userProfile").document(email2).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String userName=documentSnapshot.getString("name");
                String userEmail=documentSnapshot.getString("email");
                String userPhone=documentSnapshot.getString("phone");
                String userAddress=documentSnapshot.getString("address");
                name.setText(userName);
                email.setText(userEmail);
                phone.setText(userPhone);
                address.setText(userAddress);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });



    }


    public void saveProfile(View view) {

        String userName=name.getText().toString();
        String userEmail=email.getText().toString();
        String userPhone=phone.getText().toString();
        String userAddress=address.getText().toString();
        Map<String,Object> map=new HashMap<>();
        map.put("name",userName);
        map.put("email",userEmail);
        map.put("phone",userPhone);
        map.put("address",userAddress);
        cl.collection("userProfile").document(email2).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        Intent intent=new Intent(this,EditUserProfile.class);
        startActivity(intent);
        finish();

    }
}