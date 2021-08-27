package com.example.medicaresapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
          toolbar.setTitle("Main");
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_medical_informations, R.id.nav_shopkeepers_login)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                   case R.id.nav_home:
                      Intent intent=new Intent(getApplicationContext(),SearchMedicalActivity.class);
                      startActivity(intent);
                      break;
                    case R.id.nav_gallery:
                        Intent searchIntent=new Intent(getApplicationContext(),SearchAreaActivity.class);
                        startActivity(searchIntent);
                        break;
                    case R.id.nav_slideshow:
                        Intent adminIntent=new Intent(getApplicationContext(),AdminActivity.class);
                        startActivity(adminIntent);
                        break;
                    case R.id.nav_tools:
                        Intent registerIntent=new Intent(getApplicationContext(),AddMedicalActivity.class);
                        startActivity(registerIntent);
                        break;
                    case R.id.nav_medical_informations:
                        Intent medicalIntent=new Intent(getApplicationContext(),SearchMedicalActivity.class);
                        startActivity(medicalIntent);
                        break;
                    case R.id.nav_shopkeepers_login:
                        Intent shopkeeperIntent=new Intent(getApplicationContext(),ShopkeeperActivity.class);
                        startActivity(shopkeeperIntent);
                        break;
                }
                return false;
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
