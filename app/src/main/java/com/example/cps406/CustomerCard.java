package com.example.cps406;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

public class CustomerCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_card);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Stock bought[] = {new Stock("DogeCoin", -123.50f),
                new Stock("Pepe", 13.50f),
                new Stock("PewDew", 163.75f),
                new Stock("Samshlong", 69.69f),
        };

        ListView stocksListView = (ListView) findViewById(R.id.listview_stocks);
        TextView balanceTextView = (TextView) findViewById(R.id.textview_customer_balance);

        TextView customerNameTextView = (TextView) findViewById(R.id.textview_customer_name);
        Customer customer = Customer.get();
        balanceTextView.setText(customer.getBalance() + " $");
        customerNameTextView.setText(customer.getName());
        StockAdapter stockAdapter = new StockAdapter(getApplicationContext(), bought, null);
        stocksListView.setAdapter(stockAdapter);

    }
}