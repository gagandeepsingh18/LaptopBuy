package com.example.laptopbuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.laptopbuy.Gagan.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class changepassword extends AppCompatActivity {
    String password;
    EditText pass;
FirebaseUser firebaseUser;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        pass=findViewById(R.id.editChangePassword);

        firebaseAuth=FirebaseAuth.getInstance();
      firebaseUser=firebaseAuth.getCurrentUser();
    }
//editChangePassword connected to button for changing password
    public void editChangePassword(View view) {
        password=pass.getText().toString();
/*inbuilt method for changing password*/
firebaseUser.updatePassword(password).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {

    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception e) {

    }
});
startActivity(new Intent(changepassword.this, MainActivity.class));
    }
}