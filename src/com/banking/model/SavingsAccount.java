package com.banking.model;

public class SavingsAccount extends Account {

    private static final double MINIMUM_BALANCE = 500.0;
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance, "SAVINGS");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount!");
            return false;
        }

        double balanceAfterWithdrawal = getBalance() - amount;

        if (balanceAfterWithdrawal < MINIMUM_BALANCE) {
            System.out.println("❌ Insufficient balance! Minimum balance of ₹" +
                    MINIMUM_BALANCE + " must be maintained.");
            return false;
        }

        setBalance(balanceAfterWithdrawal);
        addTransaction("Withdrawn ₹" + amount + " | Balance: ₹" + getBalance());
        return true;
    }

    public void calculateInterest() {
        double interest = getBalance() * INTEREST_RATE;
        setBalance(getBalance() + interest);
        addTransaction("Interest credited ₹" + String.format("%.2f", interest) +
                " @ " + (INTEREST_RATE * 100) + "% | Balance: ₹" + getBalance());

        System.out.println("\n✅ Interest Calculation Complete!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Interest Rate    : " + (INTEREST_RATE * 100) + "% per annum");
        System.out.println("Interest Amount  : ₹" + String.format("%.2f", interest));
        System.out.println("New Balance      : ₹" + String.format("%.2f", getBalance()));
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    public static double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }

    public static double getInterestRate() {
        return INTEREST_RATE;
    }
}