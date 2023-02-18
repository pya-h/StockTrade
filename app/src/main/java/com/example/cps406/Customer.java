package com.example.cps406;

import static java.lang.Float.parseFloat;

import java.util.ArrayList;
import java.util.List;

class Customer implements Actor {
    private static Customer Current;
    private float balance;
    private String name;
    private List<Stock> bought;
    private List<Stock> sold;

    private Customer(float balance, String name, String information) {
        this.balance = balance;
        this.name = name;

        this.bought = new ArrayList<Stock>();
        this.sold = new ArrayList<Stock>();
    }

    public static Customer get() {
        return Current;
    }
    public static Customer logIn(String name) {
        return null;
    }

    public static Customer register(String name, String information) {
        Current = new Customer(100.0f, name, information);
        return Current;
    }

    @Override
    public float getBalance() {

        return balance;
    }

    @Override
    public void setBalance(float balance) {

        this.balance = balance;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public void setName(String name) {

        this.name = name;
    }



    public void buy(Stock stock) throws StockException {
        if (balance >= parseFloat(stock.getPrice())) {
            balance -= parseFloat(stock.getPrice());
            bought.add(stock);
        }
        else
            throw new StockException("You don\'t have enough balance!");
    }

    public void sell(Stock stock) throws StockException {
        if (bought.contains(stock)) {
            balance += parseFloat(stock.getPrice());
            bought.remove(stock);
            bought.add(stock);
        }
        else
            throw new StockException("You haven't bought this stock yet!");
    }
}
