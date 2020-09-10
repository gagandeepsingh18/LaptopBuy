package com.example.laptopbuy.Gagan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laptopbuy.CartForm_Activity;
import com.example.laptopbuy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class ProductsDetailsActivity extends AppCompatActivity {
ImageView imageView;
TextView price,name,desc;
String productPrice, productDescription, productName, productImage;

Button cart;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_details);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        imageView = findViewById(R.id.PProductImage);
        price= findViewById(R.id.PProductPrice);
        desc= findViewById(R.id.PProductDescription);
        name= findViewById(R.id.PProductTitle);
        cart= findViewById(R.id.AddtoCartButton);

        final Bundle bundle = getIntent().getExtras();
        productPrice = bundle.getString("productPrice");
        productDescription = bundle.getString("productDescription");
        productName = bundle.getString("productName");
        productImage = bundle.getString("productImage");

        name.setText(productName);
        price.setText("$"+productPrice);
        desc.setText(productDescription);
        Picasso.get().load(productImage).into(imageView);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SendDataToCart();
            }
        });


    }

    private void SendDataToCart() {
        Intent intent = new Intent(this, CartForm_Activity.class);
        intent.putExtra("name",productName);
        intent.putExtra("productDescription",productDescription);
        intent.putExtra("productPrice",productPrice);
        intent.putExtra("productImage",productImage);
        startActivity(intent);
        finish();
    }
}