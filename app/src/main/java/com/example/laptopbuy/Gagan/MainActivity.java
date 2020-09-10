package com.example.laptopbuy.Gagan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.laptopbuy.AboutusActivity;
import com.example.laptopbuy.AskmeActivity;
import com.example.laptopbuy.FaqActivity;
import com.example.laptopbuy.R;
import com.example.laptopbuy.UserProfile;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
String email;
    DrawerLayout drawerLayout;

    FragmentManager manager;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);


        Intent intent=getIntent();
        email=intent.getStringExtra("emailIntent");


       /** FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CartForm_Activity.class);
                startActivity(intent);
            }
        }); */
        drawerLayout= findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.Fragment_container,new HomeFragment());
        transaction.commit();

    }





    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_profile:
                Intent intent = new Intent(this, UserProfile.class).putExtra("emailIntent",email);
                startActivity(intent);
                break;
            case R.id.nav_home:
                Fragment fragment= new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, fragment).addToBackStack(null).commit();
                break;
            case R.id.nav_search:
                Fragment fragment1= new SearchFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, fragment1).addToBackStack(null).commit();
                break;
            case R.id.nav_faqs:
                Intent intent2 = new Intent(this, FaqActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_contactus:
                Intent intent3 = new Intent(this, AboutusActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_aboutus:
                Intent intent4 = new Intent(this, AskmeActivity.class);
                startActivity(intent4);
                break;
            case R.id.nav_logout:
                Intent intent5 = new Intent(this, LoginActivity.class);
                startActivity(intent5);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }


}