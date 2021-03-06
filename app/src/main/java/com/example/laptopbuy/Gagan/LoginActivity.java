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
import com.example.laptopbuy.ResetPassword;
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
    /**
     *  Firebase Authentication Object is declared to access Firebase Authentication service
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

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

        SkipLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SkipActivity.class);
                startActivity(intent);
            }
        });


    }
    /**
     * Function to go to registration
     */
    private void RegisterFunction() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    /**
     * Login Function
     */
    private void LoginFunction(String email, String  password) {
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    /*Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("emailIntent",email);
                    startActivity(intent);*/
                   startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("emailIntent",email));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"You have entered incorrect user credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void resetPassword(View view) {
        Intent intent=new Intent(LoginActivity.this, ResetPassword.class);
        startActivity(intent);
        finish();
    }
}