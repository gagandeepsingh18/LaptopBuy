package com.example.laptopbuy.Gagan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptopbuy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    TextView SkipLogin;
    Button Login,Register;
    EditText EmailEditText, PasswordEditText;
    String Email, Password;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        /**
         *  Firebase Authentication Object is declared to access Firebase Authentication service
         */

        Login = findViewById(R.id.LoginButton);
        Register = findViewById(R.id.RegistrationPageButton);
        SkipLogin = findViewById(R.id.SkipLogin);
        EmailEditText = findViewById(R.id.EmailInput);
        PasswordEditText = findViewById(R.id.PasswordInput);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = EmailEditText.getText().toString();
                Password = PasswordEditText.getText().toString();
                if (Email.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"User Email field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(Password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"User Password field is empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    LoginFunction(Email, Password);
                }

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFunction();
            }
        });


    }

    private void RegisterFunction() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void LoginFunction(String email, String  password) {
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"You have entered incorrect user credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}