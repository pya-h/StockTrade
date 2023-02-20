package com.example.cps406;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText usernameEditText = findViewById(R.id.edittext_username);
        EditText passwordEditText = findViewById(R.id.edittext_password);
        Button loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(view -> {
            try
            {
                Customer.logIn(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                Toast.makeText(LoginActivity.this,"you successfully logged in!", Toast.LENGTH_SHORT).show();
                Intent mainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
            catch(CustomerException ex) {
                Toast.makeText(LoginActivity.this,ex.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}