package com.example.laptopbuy.Gagan;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laptopbuy.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterProducts extends RecyclerView.Adapter<AdapterProducts.ProductHolder> {
    String productName, productDescription, productPrice, productManufacturer, productMemory, productStorage, productImage, productCPU, productGPU;

    View.OnClickListener Listener;
    List<ModelProducts> modelProducts;
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
            Log.d("Picasso", ""+exception);
        }

        holder.productNameView.setText(productName);
        holder.productDescriptionView.setText(productDescription);
        holder.productPriceView.setText("Price: $"+productPrice);
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

            //itemView.setTag(this);

          //  itemView.setOnClickListener(Listener);
        }
    }

  //  public void setOnClickListener(View.OnClickListener onClickListener){
//        Listener = onClickListener;
  //  }
}
