package com.banking.model;

public class CurrentAccount extends Account {

    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(String accountNumber, String accountHolderName, double initialBalance) {
        super(accountNumber, accountHolderName, initialBalance, "CURRENT");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid amount!");
            return false;
        }

        double balanceAfterWithdrawal = getBalance() - amount;

        if (balanceAfterWithdrawal < -OVERDRAFT_LIMIT) {
            System.out.println("❌ Insufficient balance! Overdraft limit of ₹" +
                    OVERDRAFT_LIMIT + " exceeded.");
            System.out.println("Available balance (including overdraft): ₹" +
                    (getBalance() + OVERDRAFT_LIMIT));
            return false;
        }

        setBalance(balanceAfterWithdrawal);

        String status = balanceAfterWithdrawal < 0 ? " (Overdraft)" : "";
        addTransaction("Withdrawn ₹" + amount + status + " | Balance: ₹" + getBalance());

        if (balanceAfterWithdrawal < 0) {
            System.out.println("⚠️  Account is in overdraft. Current balance: ₹" + getBalance());
        }

        return true;
    }

    public double getAvailableBalance() {
        return getBalance() + OVERDRAFT_LIMIT;
    }

    public boolean isOverdrawn() {
        return getBalance() < 0;
    }

    public static double getOverdraftLimit() {
        return OVERDRAFT_LIMIT;
    }
}