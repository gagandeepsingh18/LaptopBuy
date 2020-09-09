package com.example.laptopbuy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class AboutusActivity extends AppCompatActivity {
    //Initialize variables
    private TextView mTextView;

    DrawerLayout drawerLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);

        //Assign variable
        drawerLayout=findViewById(R.id.drawer_layout);

        Intent intent = getIntent();
        startActivity(intent);
        //getIntent() function to start About Us.
        mTextView = (TextView) findViewById(R.id.text);
    }

    public void clickAboutUs(View view){
        //Recreate activity
        recreate();
    }
    public void clickFAQ(View view){

    }

    public void fb(View view) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.fb)));
        startActivity(fbIntent);
        //Clickable image. For the time, 'Best Buy' FB' page is used.
    }

    public void insta(View view) {
        Intent instaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.insta)));
        startActivity(instaIntent);
        // A view for redirecting the user to Instagram page. For the time, 'Best Buy' insta page is used.
    }

    public void twitter(View view) {
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.twitter)));
        startActivity(twitterIntent);
        // A view for redirecting user by pressing the image to twitter account. For the time, 'Best Buy' Twitter page is linked.
    }

    public void internet(View view) {
        Intent internetIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.internet)));
        startActivity(internetIntent);
        // A view for redirecting user to 'Best Buy' Online website.
    }

}