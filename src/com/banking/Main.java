package com.banking;

import com.banking.service.BankService;
import java.util.Scanner;

/**
 * Console-Based Banking Management System
 * Features: Create Account, Deposit, Withdraw, Transfer, View Balance, Transaction History
 * @author B. Nikhil
 * @version 1.0
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BankService bankService = new BankService();

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   WELCOME TO SECURE BANKING SYSTEM         ║");
        System.out.println("║   Developed by: B. Nikhil                  ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Load existing accounts from file
        bankService.loadAccountsFromFile();

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    viewTransactionHistory();
                    break;
                case 7:
                    viewAllAccounts();
                    break;
                case 8:
                    calculateInterest();
                    break;
                case 9:
                    System.out.println("\n✅ Saving data and exiting...");
                    bankService.saveAccountsToFile();
                    System.out.println("Thank you for using Secure Banking System!");
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.\n");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n━━━━━━━━━━━━━━━ MAIN MENU ━━━━━━━━━━━━━━━");
        System.out.println("1. 🆕 Create New Account");
        System.out.println("2. 💵 Deposit Money");
        System.out.println("3. 💸 Withdraw Money");
        System.out.println("4. 🔄 Transfer Funds");
        System.out.println("5. 💰 Check Balance");
        System.out.println("6. 📊 View Transaction History");
        System.out.println("7. 📋 View All Accounts");
        System.out.println("8. 📈 Calculate Interest (Savings Only)");
        System.out.println("9. 🚪 Exit");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    private static void createAccount() {
        System.out.println("\n═══════ CREATE NEW ACCOUNT ═══════");

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.println("\nSelect Account Type:");
        System.out.println("1. Savings Account (Interest: 4% per annum)");
        System.out.println("2. Current Account (No interest, Overdraft allowed)");
        int type = getIntInput("Enter choice (1 or 2): ");

        double initialDeposit = getDoubleInput("Enter Initial Deposit (Min ₹500): ");

        if (initialDeposit < 500) {
            System.out.println("❌ Minimum deposit of ₹500 required!");
            return;
        }

        String accountType = (type == 1) ? "SAVINGS" : "CURRENT";
        String accountNumber = bankService.createAccount(name, accountType, initialDeposit);

        if (accountNumber != null) {
            System.out.println("\n✅ Account created successfully!");
            System.out.println("📌 Account Number: " + accountNumber);
            System.out.println("📌 Account Holder: " + name);
            System.out.println("📌 Account Type: " + accountType);
            System.out.println("📌 Initial Balance: ₹" + initialDeposit);
        } else {
            System.out.println("❌ Failed to create account!");
        }
    }

    private static void deposit() {
        System.out.println("\n═══════ DEPOSIT MONEY ═══════");
        String accountNumber = getStringInput("Enter Account Number: ");
        double amount = getDoubleInput("Enter Amount to Deposit: ₹");

        if (bankService.deposit(accountNumber, amount)) {
            System.out.println("✅ ₹" + amount + " deposited successfully!");
            System.out.println("Current Balance: ₹" + bankService.getBalance(accountNumber));
        } else {
            System.out.println("❌ Deposit failed! Invalid account or amount.");
        }
    }

    private static void withdraw() {
        System.out.println("\n═══════ WITHDRAW MONEY ═══════");
        String accountNumber = getStringInput("Enter Account Number: ");
        double amount = getDoubleInput("Enter Amount to Withdraw: ₹");

        if (bankService.withdraw(accountNumber, amount)) {
            System.out.println("✅ ₹" + amount + " withdrawn successfully!");
            System.out.println("Current Balance: ₹" + bankService.getBalance(accountNumber));
        } else {
            System.out.println("❌ Withdrawal failed! Insufficient balance or invalid account.");
        }
    }

    private static void transferFunds() {
        System.out.println("\n═══════ TRANSFER FUNDS ═══════");
        String fromAccount = getStringInput("Enter Your Account Number: ");
        String toAccount = getStringInput("Enter Recipient Account Number: ");
        double amount = getDoubleInput("Enter Amount to Transfer: ₹");

        if (bankService.transfer(fromAccount, toAccount, amount)) {
            System.out.println("✅ ₹" + amount + " transferred successfully!");
            System.out.println("Your Balance: ₹" + bankService.getBalance(fromAccount));
        } else {
            System.out.println("❌ Transfer failed! Check account numbers and balance.");
        }
    }

    private static void checkBalance() {
        System.out.println("\n═══════ CHECK BALANCE ═══════");
        String accountNumber = getStringInput("Enter Account Number: ");
        double balance = bankService.getBalance(accountNumber);

        if (balance >= 0) {
            System.out.println("💰 Current Balance: ₹" + balance);
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    private static void viewTransactionHistory() {
        System.out.println("\n═══════ TRANSACTION HISTORY ═══════");
        String accountNumber = getStringInput("Enter Account Number: ");
        bankService.displayTransactionHistory(accountNumber);
    }

    private static void viewAllAccounts() {
        System.out.println("\n═══════ ALL ACCOUNTS ═══════");
        bankService.displayAllAccounts();
    }

    private static void calculateInterest() {
        System.out.println("\n═══════ CALCULATE INTEREST ═══════");
        String accountNumber = getStringInput("Enter Savings Account Number: ");
        bankService.calculateAndAddInterest(accountNumber);
    }

    // Utility methods for input validation
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("❌ Invalid input! Enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return value;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("❌ Invalid input! Enter a valid amount: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return value;
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}