package com.example.cps406;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StockAdapter extends BaseAdapter{
//    String[] stockName;

    Context context;
//    int[] stockPrice;
    LayoutInflater inflater;
    Stock[] stocks;
    String job;
    private StockTradeActivity parentActivity;
    private Customer customer;
    public StockAdapter (Context context, Stock[] stocks, StockTradeActivity parent){
        this.context = context;
        this.stocks = stocks;
        this.inflater = LayoutInflater.from(context);
        this.parentActivity = parent;
        this.customer = Customer.get();
    }


    @Override
    public int getCount() {
        return stocks.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.activity_stockview, null);
        TextView stockNameTextView = (TextView) view.findViewById(R.id.textview_stock_name);
        TextView stockPriceTextView = (TextView) view.findViewById(R.id.textview_stock_price);
        Button buyButton = (Button) view.findViewById(R.id.button_buy);
        Button sellButton = (Button) view.findViewById(R.id.button_sell);

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    customer.buy(stocks[i]);
                    if(parentActivity != null)
                        parentActivity.updateBalance();
                    Toast.makeText(context.getApplicationContext(), stocks[i].getName() + " has been bought for " + stocks[i].getPrice() + ".", Toast.LENGTH_LONG).show();
                } catch (StockException ex) {
                    Toast.makeText(context.getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    customer.sell(stocks[i]);
                    if(parentActivity != null)
                        parentActivity.updateBalance();
                    Toast.makeText(context.getApplicationContext(), stocks[i].getName() + " has been sold for " + stocks[i].getPrice() + ".", Toast.LENGTH_SHORT).show();
                } catch (StockException ex) {
                    Toast.makeText(context.getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        });

        stockNameTextView.setText(stocks[i].getName());
        stockPriceTextView.setText(stocks[i].getPrice());
        return view;

    }
}
