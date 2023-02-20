package com.example.cps406;


import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView balanceTextview, usernameTextView;
    Button gotoStockTradeButton, gotoBankPortalButton;
    private static Customer customer;

    public void updateBalance() {
        balanceTextview.setText(String.format(getString(R.string.textview_balance), customer != null ? customer.getBalance() : 0.0f));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customer = Customer.get();
        usernameTextView = findViewById(R.id.textview_username);
        usernameTextView.setText(customer.getName());
        balanceTextview = findViewById(R.id.textview_balance);
        gotoStockTradeButton = findViewById(R.id.button_goto_stock_trade);
        gotoStockTradeButton.setOnClickListener(v -> {
            Intent stockTradeIntent = new Intent(MainActivity.this, StockTradeActivity.class);
            startActivity(stockTradeIntent);
        });
        gotoBankPortalButton = findViewById(R.id.button_goto_bank_portal);
        gotoBankPortalButton.setOnClickListener(v -> {
            Intent bankPortalIntent = new Intent(MainActivity.this, BankPortalActivity.class);
            startActivity(bankPortalIntent);
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        updateBalance();
    }
    @Override
    protected void onStart() {
        super.onStart();
        updateBalance();
    }
}