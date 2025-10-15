package com.ZimBank.App;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static double balance = 2000.00;
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        boolean running = true;

        // Default user
        users.put("Chiedza", "1234");

        System.out.println("===================================");
        System.out.println("     🏦  WELCOME TO ZIMBANK APP   ");
        System.out.println("===================================");
        System.out.println("Default Login: MUGAVIRI / Z116Laaz#");

        while (running) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> loginUser();
                case "2" -> registerUser();
                case "3" -> {
                    System.out.println("👋 Thank you for using ZimBank. Goodbye!");
                    running = false;
                }
                default -> System.out.println("⚠ Invalid choice. Try again.");
            }
        }

        sc.close();
    }

    // --------------------- LOGIN ---------------------
    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("✅ Login successful! Welcome, " + username + "!");
            showBankingMenu(username);
        } else {
            System.out.println("❌ Invalid username or password!");
        }
    }

    // --------------------- REGISTER ---------------------
    private static void registerUser() {
        System.out.println("\n=== ACCOUNT REGISTRATION ===");
        System.out.print("Enter desired username: ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("⚠ Username already exists! Try a different one.");
            return;
        }

        System.out.print("Enter new password: ");
        String password = sc.nextLine();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("❌ Username and password cannot be empty.");
            return;
        }

        users.put(username, password);
        System.out.println("✅ Registration successful! You can now log in as: " + username);
    }

    // --------------------- BANKING MENU ---------------------
    private static void showBankingMenu(String username) {
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n=== ZIMBANK MENU ===");
            System.out.println("1. View Profile");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transaction History");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> viewUserProfile(username);
                case "2" -> checkBalance();
                case "3" -> depositMoney();
                case "4" -> withdrawMoney();
                case "5" -> showTransactionHistory();
                case "6" -> {
                    System.out.println("🔒 Logging out...");
                    loggedIn = false;
                }
                default -> System.out.println("⚠ Invalid option. Try again.");
            }
        }
    }

    // --------------------- PROFILE ---------------------
    private static void viewUserProfile(String username) {
        System.out.println("\n=== USER PROFILE ===");
        System.out.println("Username: " + username);
        System.out.println("Full Name: CHIEDZA Mugaviri");
        System.out.println("Email: mugavirichiedza@gmail");
        System.out.println("Phone: +263 772 889 456");
        System.out.println("Account Type: Current Account");
        System.out.println("Account Status: Active");
        System.out.println("Member Since: March 2025");
        System.out.println("=============================");
    }

    // --------------------- BALANCE ---------------------
    private static void checkBalance() {
        System.out.println("\n💰 Current Balance: $" + String.format("%.2f", balance));
    }

    // --------------------- DEPOSIT ---------------------
    private static void depositMoney() {
        System.out.print("Enter amount to deposit: $");
        try {
            double amount = Double.parseDouble(sc.nextLine());
            if (amount > 0) {
                balance += amount;
                System.out.printf("✅ Deposited: $%.2f%nNew Balance: $%.2f%n", amount, balance);
            } else {
                System.out.println("⚠ Invalid amount!");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠ Please enter a valid number!");
        }
    }

    // --------------------- WITHDRAW ---------------------
    private static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: $");
        try {
            double amount = Double.parseDouble(sc.nextLine());
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.printf("✅ Withdrawn: $%.2f%nNew Balance: $%.2f%n", amount, balance);
            } else if (amount > balance) {
                System.out.println("❌ Insufficient funds!");
            } else {
                System.out.println("⚠ Invalid amount!");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠ Please enter a valid number!");
        }
    }

    // --------------------- TRANSACTION HISTORY ---------------------
    private static void showTransactionHistory() {
        System.out.println("\n=== TRANSACTION HISTORY ===");
        System.out.println("1. Account Created – Initial Deposit: $2000.00");
        System.out.println("2. Balance Checked – ZimBank System");
        System.out.println("3. Deposits & Withdrawals shown in logs (future feature)");
        System.out.println("===========================");
    }
}
