package com.example.laptopbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laptopbuy.Gagan.MainActivity;
import com.google.firebase.firestore.FirebaseFirestore;

public class PaymentDetails_Activity extends AppCompatActivity {

String name,price,adress,city,province,zipcode;
EditText cardnumber,cardname;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details_);
        db=FirebaseFirestore.getInstance();
        name=getIntent().getStringExtra("name");
        price=getIntent().getStringExtra("price");
        adress=getIntent().getStringExtra("adress");
        zipcode=getIntent().getStringExtra("zipcode");
        city =getIntent().getStringExtra("city");
        province=getIntent().getStringExtra("province");
        cardname=findViewById(R.id.cardname);
        cardnumber=findViewById(R.id.cardnumber);
    }

    public void done(View view) {
      //  pojoCart product=new pojoCart(adress,zipcode,city, province,name,price, cardname.getText().toString(),cardnumber.getText().toString());
       // db.collection("Cart")
        //        .document(name).set(product);
        Intent intent=new Intent(PaymentDetails_Activity.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext()," Succesfull",Toast.LENGTH_LONG).show();

    }
}