package com.example.cps406;

import static java.lang.Float.parseFloat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Customer {
    private static Customer Current;
    private float balance;
    private String name;
    private List<Stock> bought;
    private List<Stock> sold;
    private static Map<String, String> TestUsers = new HashMap<>();

    private Customer(float balance, String name, String information) {
        this.balance = balance;
        this.name = name;

        this.bought = new ArrayList<Stock>();
        this.sold = new ArrayList<Stock>();
    }

    private static void InitTest() {
        if(TestUsers == null)
            TestUsers = new HashMap<>();
        TestUsers.put("test", "test");
        TestUsers.put("Ali", "123");
        TestUsers.put("Reza", "666");
        TestUsers.put("Paya", "419");
        TestUsers.put("Tool", "Maynard");

    }
    public static Customer get() {
        return Current;
    }
    public static Customer logIn(String username, String password) throws CustomerException {
        if(TestUsers == null || TestUsers.size() == 0)
            InitTest();
        Current = null;
        if(!TestUsers.containsKey(username) || !TestUsers.get(username).equals(password))
            throw new CustomerException("Username or password is incorrect!");
        Current = new Customer(0.0f, username, "");
        return Current;
    }

    public static Customer register(String name, String information) {
        Current = new Customer(0.0f, name, information);
        return Current;
    }

    public float getBalance() {

        return balance;
    }

    public void setBalance(float balance) {

        this.balance = balance;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void invest(float amount) throws StockException {
        if(amount <= 0)
            throw new StockException("Investment amount must be positive and valid1");
        this.balance += amount;
    }
    public void buy(Stock stock) throws StockException {
        if (balance >= stock.getPrice()) {
            balance -= stock.getPrice();
            bought.add(stock);
        }
        else
            throw new StockException("You don\'t have enough balance!");
    }

    public void sell(Stock stock) throws StockException {
        if (bought.contains(stock)) {
            balance += stock.getPrice();
            bought.remove(stock);
            bought.add(stock);
        }
        else
            throw new StockException("You haven't bought this stock yet!");
    }
}
