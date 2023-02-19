package com.example.cps406;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class BankPortalActivity extends AppCompatActivity {
    EditText bankNameEditText, investAmountEditText;
    Button investButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_portal);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        bankNameEditText = findViewById(R.id.edittext_bank_name);
        investAmountEditText = findViewById(R.id.edittext_invest_amount);
        investButton = findViewById(R.id.button_invest);
        Customer customer = Customer.get();
        investButton.setOnClickListener(v -> {
            if(customer != null) {
                try {
                    final String bankName = bankNameEditText.getText().toString(); // used for whatever
                    final float amount = Float.parseFloat(investAmountEditText.getText().toString());
                    customer.invest(amount);
                    Toast.makeText(BankPortalActivity.this,
                            String.format("%.2f $ successfully invested from your %s bank account.", amount, bankName)
                            , Toast.LENGTH_SHORT).show();

                    finish(); // close activity
                } catch (StockException | NumberFormatException e) {
                    Toast.makeText(BankPortalActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(BankPortalActivity.this, "You must login first!", Toast.LENGTH_SHORT).show();
            }

        });
    }
}