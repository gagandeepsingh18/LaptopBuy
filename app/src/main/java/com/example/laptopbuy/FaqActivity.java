package com.example.laptopbuy;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class FaqActivity extends AppCompatActivity {


    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq);

    }

    public void AskMe(View view) {
        Intent AskMeIntent = new Intent(this, AskmeActivity.class);
        startActivity(AskMeIntent);
        //**Here, the Ask Me Activity is being started upon pressing the Ask Me button.*/
    }

    public void AboutUs(View view) {
        Intent AboutUsIntent = new Intent(this, AboutusActivity.class);
        startActivity(AboutUsIntent);
        //** Here, the About Us activity is being started upon pressing the About Us button.*/
    }
}