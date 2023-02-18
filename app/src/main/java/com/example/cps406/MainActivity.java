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
    Button gotoStockTradeButton;
    private static Customer customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customer = Customer.register("test", "whatever");
        usernameTextView = findViewById(R.id.textview_username);
        usernameTextView.setText(customer.getName());
        balanceTextview = findViewById(R.id.textview_balance);

        balanceTextview.setText(String.format(getString(R.string.textview_balance), customer.getBalance()));
        gotoStockTradeButton = findViewById(R.id.button_goto_stock_trade);
        gotoStockTradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stockTradeIntent = new Intent(MainActivity.this, StockTradeActivity.class);
                startActivity(stockTradeIntent);
            }
        });
    }
}