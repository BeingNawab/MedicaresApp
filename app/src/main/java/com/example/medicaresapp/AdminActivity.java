package com.example.medicaresapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {
    EditText inputEmail,inputPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btnLogin=findViewById(R.id.login);
        inputEmail=findViewById(R.id.editEmail);
        inputPassword=findViewById(R.id.editPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String email=inputEmail.getText().toString();
               String pass=inputPassword.getText().toString();
               if (email.equals("Admin") && pass.equals("1234")){
                   Intent intent=new Intent(AdminActivity.this,SearchMedicalActivity.class);
                   startActivity(intent);
               }
            }
        });
    }
}