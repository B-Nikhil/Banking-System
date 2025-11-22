package com.banking.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private LocalDateTime createdDate;
    private List<String> transactionHistory;

    public Account(String accountNumber, String accountHolderName, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.createdDate = LocalDateTime.now();
        this.transactionHistory = new ArrayList<>();

        addTransaction("Account created with initial deposit of ₹" + initialBalance);
    }

    public abstract boolean withdraw(double amount);

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        this.balance += amount;
        addTransaction("Deposited ₹" + amount + " | Balance: ₹" + this.balance);
        return true;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (this.withdraw(amount)) {
            toAccount.deposit(amount);
            addTransaction("Transferred ₹" + amount + " to A/C " + toAccount.getAccountNumber());
            toAccount.addTransaction("Received ₹" + amount + " from A/C " + this.accountNumber);
            return true;
        }
        return false;
    }

    protected void addTransaction(String transaction) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        transactionHistory.add("[" + timestamp + "] " + transaction);
    }

    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n📊 Transaction History for A/C: " + accountNumber);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    public void displayAccountInfo() {
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│         ACCOUNT INFORMATION             │");
        System.out.println("├─────────────────────────────────────────┤");
        System.out.printf("│ Account Number  : %-21s │%n", accountNumber);
        System.out.printf("│ Holder Name     : %-21s │%n", accountHolderName);
        System.out.printf("│ Account Type    : %-21s │%n", accountType);
        System.out.printf("│ Balance         : ₹%-20.2f │%n", balance);
        System.out.printf("│ Created Date    : %-21s │%n",
                createdDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        System.out.println("└─────────────────────────────────────────┘");
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append(accountNumber).append("|");
        sb.append(accountHolderName).append("|");
        sb.append(balance).append("|");
        sb.append(accountType).append("|");
        sb.append(createdDate).append("|");
        sb.append(String.join(";;", transactionHistory));
        return sb.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    public void setTransactionHistory(List<String> history) {
        this.transactionHistory = new ArrayList<>(history);
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime date) {
        this.createdDate = date;
    }
}