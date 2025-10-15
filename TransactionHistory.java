package com.ZimBank.util;

import java.util.ArrayList;
import java.util.List;

/**
 * TransactionHistory class manages a list of transaction records.
 * It allows adding new transactions and displaying the full history.
 */
public class TransactionHistory {

    // List to store all transaction details
    private List<String> transactions = new ArrayList<>();

    // Method to add a transaction record
    public void addTransaction(String detail) {
        transactions.add(detail);
    }

    // Method to display all transaction records
    public void displayTransactions() {
        System.out.println("\n=== TRANSACTION HISTORY ===");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactions) {
                System.out.println("- " + t);
            }
        }

        System.out.println("============================\n");
    }

    // Optional: clear all transactions
    public void clearHistory() {
        transactions.clear();
        System.out.println("Transaction history cleared.");
    }
}

