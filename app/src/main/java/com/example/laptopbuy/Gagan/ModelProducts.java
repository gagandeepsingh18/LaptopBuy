package com.example.laptopbuy.Gagan;

import android.os.Parcel;
import android.os.Parcelable;
/**
 *  Pojo class to get and set data
 */

public class ModelProducts implements Parcelable {
    String productName, productDescription, productPrice, productManufacturer, productMemory, productStorage, productImage, productCPU, productGPU;



    protected ModelProducts(Parcel in) {
        productName = in.readString();
        productDescription = in.readString();
        productPrice = in.readString();
        productManufacturer = in.readString();
        productMemory = in.readString();
        productStorage = in.readString();
        productImage = in.readString();
        productCPU = in.readString();
        productGPU = in.readString();
    }

    public static final Creator<ModelProducts> CREATOR = new Creator<ModelProducts>() {
        @Override
        public ModelProducts createFromParcel(Parcel in) {
            return new ModelProducts(in);
        }

        @Override
        public ModelProducts[] newArray(int size) {
            return new ModelProducts[size];
        }
    };

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductMemory() {
        return productMemory;
    }

    public void setProductMemory(String productMemory) {
        this.productMemory = productMemory;
    }

    public String getProductStorage() {
        return productStorage;
    }

    public void setProductStorage(String productStorage) {
        this.productStorage = productStorage;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductCPU() {
        return productCPU;
    }

    public void setProductCPU(String productCPU) {
        this.productCPU = productCPU;
    }

    public String getProductGPU() {
        return productGPU;
    }

    public void setProductGPU(String productGPU) {
        this.productGPU = productGPU;
    }

  public ModelProducts(String productName, String productDescription, String productPrice, String productManufacturer, String productMemory, String productStorage, String productImage, String productCPU, String productGPU) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productManufacturer = productManufacturer;
        this.productMemory = productMemory;
        this.productStorage = productStorage;
        this.productImage = productImage;
        this.productCPU = productCPU;
        this.productGPU = productGPU;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productName);
        dest.writeString(productDescription);
        dest.writeString(productPrice);
        dest.writeString(productManufacturer);
        dest.writeString(productMemory);
        dest.writeString(productStorage);
        dest.writeString(productImage);
        dest.writeString(productCPU);
        dest.writeString(productGPU);
    }
}
