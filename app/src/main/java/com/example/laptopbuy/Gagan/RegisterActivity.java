package com.example.laptopbuy.Gagan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laptopbuy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    EditText FName, LName, EMail, UPassword, CPassword;
    String fname,lname,email,upassword, cpassword;
    Button Loginbtn,Registerbtn;

    /**
     * Create instances of Firebase Database & Authentication to access Firebase services
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        Registerbtn = findViewById(R.id.RegisterButton);
        Loginbtn =    findViewById(R.id.LoginPageButton);

        FName = findViewById(R.id.FNameInput);
        LName = findViewById(R.id.LNameInput);
        EMail = findViewById(R.id.EmailInput);
        UPassword = findViewById(R.id.PasswordInput);
        CPassword = findViewById(R.id.ConfirmPasswordInput);





        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFunction();
            }
        });

        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname = FName.getText().toString();
                lname = LName.getText().toString();
                email = EMail.getText().toString();
                upassword = UPassword.getText().toString();
                cpassword = CPassword.getText().toString();

                if (fname.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"First Name field is empty", Toast.LENGTH_SHORT).show();
                }
                else if (lname.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"Last Name field is empty", Toast.LENGTH_SHORT).show();
                }
                else if (email.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"User Email field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(upassword.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"User Password field is empty", Toast.LENGTH_SHORT).show();
                }
                else if (cpassword.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"User Password field is empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RegisterFunction(email, upassword, cpassword, fname, lname);
                }
            }
        });
    }

    /**
     *  Registration Function
     */

    private void RegisterFunction(String email, String upassword, String cpassword, String fname, String lname) {
        if (upassword.equals(cpassword)) {

            firebaseAuth.createUserWithEmailAndPassword(email, upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        String userEmail = user.getEmail();
                        String userId = user.getUid();

                        HashMap<Object, String> hashMap = new HashMap<>();
                        hashMap.put("email", userEmail);
                        hashMap.put("firstName", fname);
                        hashMap.put("lastName", lname);
                        hashMap.put("uId", userId);

                        firebaseFirestore.collection("UsersProfile").document(user.getUid()).set(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                FirebaseAuth.getInstance().signOut();
                            }
                        });
                       // FirebaseDatabase database = FirebaseDatabase.getInstance();
                     //   DatabaseReference Reference = database.getReference("");

                      //  Reference.child(userId).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                      //      @Override
                        //    public void onSuccess(Void aVoid) {
                      //
                     //       }
                    //    });
                    } else {

                        Toast.makeText(RegisterActivity.this, "Something is wrong. Please try again", Toast.LENGTH_LONG).show();
                        FirebaseAuth.getInstance().signOut();
                    }
                }
            });

        } else {
            Toast.makeText(RegisterActivity.this, "Value of Password and Confirm Password does not match", Toast.LENGTH_LONG).show();

        }
    }

    private void LoginFunction() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}