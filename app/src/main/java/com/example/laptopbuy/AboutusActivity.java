package com.example.laptopbuy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutusActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        Intent intent = getIntent();
        startActivity(intent);
//Here, About us activity is being started by getIntent() function.
        mTextView = (TextView) findViewById(R.id.text);
    }

    public void fb(View view) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.fb)));
        startActivity(fbIntent);
// A view is created for clickable image. For the time, Best Buy Fb page is used.
    }

    public void insta(View view) {
        Intent instaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.insta)));
        startActivity(instaIntent);
        // A view is created to redirect user by pressing the image to instagram page. For the time, Best buy insta page is used.
    }

    public void twitter(View view) {
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.twitter)));
        startActivity(twitterIntent);
        // A view is created to redirect user by pressing the image to twitter account. For the time, Best Buy Twitter page is linked.
    }

    public void internet(View view) {
        Intent internetIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.internet)));
        startActivity(internetIntent);
        // A view is created which will redirect user to Best Buy Online website.
    }

}