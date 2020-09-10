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
TextView price,name,desc, manufacturer, memory, storage, cPU, gPU;
String productPrice, productDescription, productName, productImage, productManufacturer,
        productMemory, productStorage,productCPU, productGPU;

ModelProducts modelProducts;

Button cart;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_details);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        imageView = findViewById(R.id.ProductDetailsImage);
        price= findViewById(R.id.ProductDetailsPrice);
        desc= findViewById(R.id.ProductDetailsDescription);
        name= findViewById(R.id.ProductDetailsTitle);
        manufacturer= findViewById(R.id.ProductDetailsManufacturer);
        memory= findViewById(R.id.ProductDetailsMemory);
        storage= findViewById(R.id.ProductDetailsStorage);
        cPU= findViewById(R.id.ProductDetailsCPU);
        gPU= findViewById(R.id.ProductDetailsGPU);
        cart= findViewById(R.id.CartButton);




       final Bundle bundle = getIntent().getExtras();
        productPrice = bundle.getString("productPrice");
        productDescription = bundle.getString("productDescription");
        productName = bundle.getString("productName");
        productImage = bundle.getString("productImage");
        productManufacturer = bundle.getString("productManufacturer");
        productMemory = bundle.getString("productMemory");
        productStorage = bundle.getString("productStorage");
        productCPU = bundle.getString("productCPU");
        productGPU = bundle.getString("productGPU");

        name.setText(productName);
        price.setText("$"+productPrice);
        desc.setText(productDescription);
        manufacturer.setText(productManufacturer);
        memory.setText(productMemory);
        storage.setText(productStorage);
        cPU.setText(productCPU);
        gPU.setText(productGPU);
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