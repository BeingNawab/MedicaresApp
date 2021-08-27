package com.example.medicaresapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    TextView btn;
    private EditText inputUsername,inputEmail,inputPassword,inputConfirmPassword;
    private Button btnRegister;
    private FirebaseAuth mAuth;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn=findViewById(R.id.AlreadyHaveAccount);
        inputUsername=findViewById(R.id.editUsername);
        inputEmail=findViewById(R.id.editEmail);
        inputPassword=findViewById(R.id.editPassword);
        inputConfirmPassword=findViewById(R.id.editConfirmPassword);
        btnRegister=findViewById(R.id.register);
        mAuth=FirebaseAuth.getInstance();
        dialog=new ProgressDialog(RegisterActivity.this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cheakCredentials();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
    private void cheakCredentials() {
        String username=inputUsername.getText().toString();
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String confirmPassword=inputConfirmPassword.getText().toString();
        if (username.isEmpty() || username.length()<3){

            inputUsername.setError("username is not valid");

        }else if (email.isEmpty() || !email.contains("@")){
            inputEmail.setError("email id is not valid");

        }else if (password.isEmpty() || password.length()<6){
            inputPassword.setError("password must be greater than 6");

        }else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)){
            inputConfirmPassword.setError("password is not matching");

        }else {
            dialog.setTitle("Registration");
            dialog.setMessage("please wait.....");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        dialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,task.getException().toString(),Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                }
            });

        }

    }
}
