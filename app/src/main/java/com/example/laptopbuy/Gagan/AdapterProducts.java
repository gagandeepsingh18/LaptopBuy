package com.example.laptopbuy.Gagan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laptopbuy.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ProductHolder> {
    String productName, productDescription, productPrice, productManufacturer, productMemory, productStorage, productImage, productCPU, productGPU;


    List<ModelProducts> modelProducts;
    View.OnClickListener Listener;
    Context context;


    public AdapterProducts(List<ModelProducts> modelProducts, Context context) {
        this.modelProducts = modelProducts;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productView = LayoutInflater.from(context).inflate(R.layout.recycle_view_products, parent, false);

        return new ProductHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        productName = modelProducts.get(position).getProductName();
        productDescription = modelProducts.get(position).getProductDescription();
        productPrice = modelProducts.get(position).getProductPrice();
        productManufacturer = modelProducts.get(position).getProductManufacturer();
        productMemory = modelProducts.get(position).getProductMemory();
        productStorage = modelProducts.get(position).getProductStorage();
        productImage = modelProducts.get(position).getProductImage();
        productCPU = modelProducts.get(position).getProductCPU();
        productGPU = modelProducts.get(position).getProductGPU();

        try {
            Picasso.get().load(productImage).into(holder.productImageView);
        }catch (Exception exception){
            Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT).show();
        }

        holder.productNameView.setText(productName);
        holder.productDescriptionView.setText(productDescription);
        holder.productPriceView.setText("Price: $"+productPrice);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
            String productName, productDescription, productPrice, productManufacturer, productMemory, productStorage, productImage, productCPU, productGPU;

            @Override
            public void onClick(View v) {


                productName = modelProducts.get(position).getProductName();
                productDescription = modelProducts.get(position).getProductDescription();
                productPrice = modelProducts.get(position).getProductPrice();
                productManufacturer = modelProducts.get(position).getProductManufacturer();
                productMemory = modelProducts.get(position).getProductMemory();
                productStorage = modelProducts.get(position).getProductStorage();
                productImage = modelProducts.get(position).getProductImage();
                productCPU = modelProducts.get(position).getProductCPU();
                productGPU = modelProducts.get(position).getProductGPU();

                Bundle bundle= new Bundle();
                bundle.putString("productName", productName);
                bundle.putString("productDescription", productDescription);
                bundle.putString("productManufacturer", productManufacturer);
                bundle.putString("productPrice", productPrice);
                bundle.putString("productMemory", productMemory);
                bundle.putString("productStorage", productStorage);
                bundle.putString("productImage", productImage);
                bundle.putString("productCPU", productCPU);
                bundle.putString("productGPU", productGPU);

                Intent intent = new Intent(context, ProductsDetailsActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelProducts.size();
    }


    public class ProductHolder extends RecyclerView.ViewHolder{
        ImageView productImageView;
        TextView productNameView;
        TextView productDescriptionView;
        TextView productPriceView;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.ProductImage);
            productNameView = itemView.findViewById(R.id.ProductTitle);
            productDescriptionView = itemView.findViewById(R.id.ProductDescription);
            productPriceView = itemView.findViewById(R.id.ProductPrice);



        }
    }


}
