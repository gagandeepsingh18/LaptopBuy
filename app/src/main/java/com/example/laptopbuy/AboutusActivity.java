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
        Intent intent=getIntent();
        startActivity(intent);
//Here, About us activity is being started by getIntent() function.
        mTextView = (TextView) findViewById(R.id.text);
    }
    public void fb(View view){
        Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.fb)));
startActivity(fbIntent);
    }
    public void insta(View view){
        Intent instaIntent = new Intent (Intent.ACTION_VIEW, Uri.parse(getString(R.string.insta)));
        startActivity(instaIntent);
    }
    public void twitter(View view){
        Intent twitterIntent= new Intent (Intent.ACTION_VIEW,Uri.parse(getString(R.string.twitter)));
        startActivity(twitterIntent);
    }
    public void internet(View view){
        Intent internetIntent = new Intent (Intent.ACTION_VIEW,Uri.parse(getString(R.string.internet)));
        startActivity(internetIntent);
    }

}