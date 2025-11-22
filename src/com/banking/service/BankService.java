package com.banking.service;

import com.banking.model.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class BankService {

    private Map<String, Account> accounts;
    private static final String DATA_FILE = "data/accounts.txt";
    private int accountCounter;

    public BankService() {
        this.accounts = new HashMap<>();
        this.accountCounter = 1001;
    }

    public String createAccount(String name, String type, double initialDeposit) {
        String accountNumber = "ACC" + accountCounter++;
        Account account;

        if (type.equalsIgnoreCase("SAVINGS")) {
            account = new SavingsAccount(accountNumber, name, initialDeposit);
        } else if (type.equalsIgnoreCase("CURRENT")) {
            account = new CurrentAccount(accountNumber, name, initialDeposit);
        } else {
            return null;
        }

        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("❌ Account not found!");
            return false;
        }

        return account.deposit(amount);
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("❌ Account not found!");
            return false;
        }

        return account.withdraw(amount);
    }

    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("❌ One or both accounts not found!");
            return false;
        }

        if (fromAccountNumber.equals(toAccountNumber)) {
            System.out.println("❌ Cannot transfer to the same account!");
            return false;
        }

        return fromAccount.transfer(toAccount, amount);
    }

    public double getBalance(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            return -1;
        }
        return account.getBalance();
    }

    public void displayTransactionHistory(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        account.displayTransactionHistory();
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found in the system.");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        ALL BANK ACCOUNTS                           ║");
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-12s ║ %-20s ║ %-10s ║ %-12s ║%n",
                "A/C Number", "Holder Name", "Type", "Balance");
        System.out.println("╠════════════════════════════════════════════════════════════════════╣");

        for (Account account : accounts.values()) {
            System.out.printf("║ %-12s ║ %-20s ║ %-10s ║ ₹%-11.2f ║%n",
                    account.getAccountNumber(),
                    truncate(account.getAccountHolderName(), 20),
                    account.getAccountType(),
                    account.getBalance()
            );
        }

        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
        System.out.println("Total Accounts: " + accounts.size());
    }

    public void calculateAndAddInterest(String accountNumber) {
        Account account = accounts.get(accountNumber);

        if (account == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        if (!(account instanceof SavingsAccount)) {
            System.out.println("❌ Interest calculation is only available for Savings Accounts!");
            return;
        }

        SavingsAccount savingsAccount = (SavingsAccount) account;
        savingsAccount.calculateInterest();
    }

    public void saveAccountsToFile() {
        try {
            File directory = new File("data");
            if (!directory.exists()) {
                directory.mkdir();
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
                writer.println(accountCounter);

                for (Account account : accounts.values()) {
                    writer.println(account.toFileString());
                }

                System.out.println("✅ Data saved successfully!");
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    public void loadAccountsFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            System.out.println("📝 No previous data found. Starting fresh!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                accountCounter = Integer.parseInt(line);
            }

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 5) {
                    String accNum = parts[0];
                    String name = parts[1];
                    double balance = Double.parseDouble(parts[2]);
                    String type = parts[3];
                    LocalDateTime createdDate = LocalDateTime.parse(parts[4]);

                    Account account;
                    if (type.equals("SAVINGS")) {
                        account = new SavingsAccount(accNum, name, balance);
                    } else {
                        account = new CurrentAccount(accNum, name, balance);
                    }

                    account.setCreatedDate(createdDate);

                    if (parts.length > 5 && !parts[5].isEmpty()) {
                        List<String> transactions = Arrays.asList(parts[5].split(";;"));
                        account.setTransactionHistory(transactions);
                    }

                    accounts.put(accNum, account);
                }
            }

            System.out.println("✅ Loaded " + accounts.size() + " accounts from file.");
        } catch (IOException e) {
            System.out.println("⚠️  Error loading data: " + e.getMessage());
        }
    }

    private String truncate(String str, int length) {
        if (str.length() <= length) {
            return str;
        }
        return str.substring(0, length - 3) + "...";
    }

    public int getTotalAccounts() {
        return accounts.size();
    }
}