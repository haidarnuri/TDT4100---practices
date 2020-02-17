package com.company;

public class Account {

    private double balance;
    private double interestRate;

    public Account(){
        this.balance = 0;
        this.interestRate=0;
    }

    public Account(double balance, double interestRate){
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void deposit(double newBalance){
        if(newBalance>0) {
            this.balance += newBalance;}
    }

    public void addInterest(){
        double interestAmount = this.balance*this.interestRate/100;
        deposit(interestAmount);
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString(){
        return "Account info: \n\tBalance:" + getBalance() + "\n\tIntrest rate: " + getInterestRate();
    }

}
