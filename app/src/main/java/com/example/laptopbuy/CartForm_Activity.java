package com.example.laptopbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class
CartForm_Activity extends AppCompatActivity {
    Button profile, faq,BTN;
    String productPrice, productDescription, productName, productImage;
 ImageView imageView;
TextView description,laptopCost,pnm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartform);

         BTN=findViewById(R.id.proceed);
        imageView=findViewById(R.id.pimg);
        laptopCost=findViewById(R.id.laptopcost);
        pnm=findViewById(R.id.pnm);
        profile=findViewById(R.id.profile);
        description=findViewById(R.id.pconfig);
        Intent intent=getIntent();
        productName=intent.getStringExtra("name");
        productImage=intent.getStringExtra("productImage");
        productPrice=intent.getStringExtra("productPrice");
        productDescription=intent.getStringExtra("productDescription");

        pnm.setText(productName);
        laptopCost.setText(productPrice);
        description.setText(productDescription);
        Picasso.get().load(productImage).into(imageView);

        BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tnt=new Intent(CartForm_Activity.this, AdressDelievery_Activity.class);
                tnt.putExtra("name",productName);
                tnt.putExtra("price",productPrice);
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