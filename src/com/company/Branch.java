package com.company;

import java.util.ArrayList;

public class Branch {

    private String bankBranchName;
    private ArrayList<Customer> customerArrayList;

    public Branch(String bankBranchName) {
        this.bankBranchName = bankBranchName;
        this.customerArrayList = new ArrayList<>();
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public boolean addCustomer(String customerName, Double firstTransaction){

           return addCustomer(new Customer(customerName, firstTransaction));

    }

    public boolean addCustomer(Customer newCustomer){
        if(findCustomer(newCustomer.getCustomerName()) > -1) {

            customerArrayList.add(newCustomer);

            return true;
        }
        else{
            return false;
        }

    }

    public void addTransaction(String customerName, Double transaction){

        int index = findCustomer(customerName);
        customerArrayList.get(index).addTransactions(transaction);


        }


    public int findCustomer(String customerName){
        for (int i = 0; i < customerArrayList.size() ; i++) {
            if(customerName.equals(customerArrayList.get(i).getCustomerName())){
                return i;
            }
        }
        return -1;
    }

    public Customer getCustomer(int i){
        return customerArrayList.get(i);
    }

    public void printCustomerList(){
        for (int i = 0; i < customerArrayList.size(); i++) {
            System.out.println((i+1) + ": " +customerArrayList.get(i).getCustomerName());
        }
    }
}

