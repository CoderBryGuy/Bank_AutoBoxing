package com.company;

import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> bankBranchArrayList;

    public Bank(){
        bankBranchArrayList = new ArrayList<>();
    }

    public Bank(String bankName){
        this.bankName = bankName;
        bankBranchArrayList = new ArrayList<>();
    }

    public void addBranch(String branchName){
        bankBranchArrayList.add(new Branch(branchName));
    }

    public void addCustomerToBranch(String branchName, String customerName, Double transaction){

        int index = findBranch(branchName);

        if(bankBranchArrayList.get(index).addCustomer(new Customer(customerName, transaction))){
            System.out.println(customerName + " account created successfully");
        }else {
            System.out.println(customerName + " already has an account at branch: "
                    + bankBranchArrayList.get(index).getBankBranchName());
        }

    }

    public void addTransactionToCustomerAccount(String branchName, String customerName, Double transaction){

        int branchIndex = findBranch(branchName);

        int customerIndex = bankBranchArrayList.get(branchIndex).findCustomer(customerName);
       Customer currentCustomer = bankBranchArrayList.get(branchIndex).getCustomer(customerIndex);
       currentCustomer.addTransactions(transaction);
    }

    public int findBranch(String branchName){
        for (int i = 0; i < bankBranchArrayList.size(); i++) {
            if(branchName.equals(bankBranchArrayList.get(i).getBankBranchName())){
                return i;
            }
        }
        return -1;
    }
}
