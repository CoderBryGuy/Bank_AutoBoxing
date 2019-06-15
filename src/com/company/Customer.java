package com.company;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String customerName) {
        this.customerName = customerName;
        this.transactions.add(0.0);
    }

    public Customer(String customerName, Double firstTransaction) {
        this.customerName = customerName;
        this.transactions.add(firstTransaction);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void printTransactions(){
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("Transaction " + i + ": " + transactions.get(i));
        }
    }

    public void addTransactions(Double newTransaction){
        transactions.add(newTransaction);
        }

    public void updateCustomerName(String customerName){
        this.customerName = customerName;
    }

}
