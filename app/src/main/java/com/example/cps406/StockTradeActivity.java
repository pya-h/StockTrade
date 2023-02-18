package com.example.cps406;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class StockTradeActivity extends AppCompatActivity {
    private static Adapter adapter;
    Context context;
    private Button buyButton;
    private Button sellButton;
    private TextView balanceButton;
    private Customer customer;
    Stock stocks[] = {new Stock("Apple", "123.50"),
            new Stock("Microsoft", "13.50"),
            new Stock("BMX", "163.75"),
            new Stock("Samsung", "83.54"),
            new Stock("Apple", "123.50"),
            new Stock("Microsoft", "13.50"),
            new Stock("BMX", "163.75"),
            new Stock("Samsung", "83.54"),
            new Stock("Apple", "123.50"),
            new Stock("Microsoft", "13.50"),
            new Stock("BMX", "163.75"),
            new Stock("Samsung", "83.54"),
            new Stock("Apple", "123.50"),
            new Stock("Microsoft", "13.50"),
            new Stock("BMX", "163.75"),
            new Stock("Samsung", "83.54"),
            new Stock("Apple", "123.50"),
            new Stock("Microsoft", "13.50"),
            new Stock("BMX", "163.75"),
            new Stock("Samsung", "83.54"),
            new Stock("Jack Daniels", "13.50")};


    public void updateBalance() {
        TextView balanceTextView = findViewById(R.id.textview_balance);
        balanceTextView.setText(String.format(getString(R.string.textview_balance), customer != null ? customer.getBalance() : 0.0f));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent = new Intent(this, StockView.class);
//        intent.putExtra("balance", ballancetextView.getText().toString());
        context = this;

//        ballancetextView.setText("This works?!");
//        startActivity(intent);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.activity_app_bar);


        customer = Customer.get();
        setContentView(R.layout.activity_stock_trade);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        updateBalance();
        ListView stocksListView = (ListView) findViewById(R.id.listview_stocks);


        StockAdapter stocksListAdapter = new StockAdapter(getApplicationContext(), stocks, this);
        stocksListView.setAdapter(stocksListAdapter);


        ImageView customerImageView = findViewById(R.id.image_button_goto_wallet);
        customerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StockTradeActivity.this, CustomerCard.class);
                startActivity(intent);
            }
        });

    }
//    public static void setBal(String x){
//        String sol = String.valueOf(parseFloat(bal.toString()) - parseFloat(x));
//        bal.setText(sol);
//    }
//
//    public static String getBal() {
//        return bal.toString();
//    }
}