package com.ZimBank.service;

import com.ZimBank.model.User;
import com.ZimBank.util.TransactionHistory;

public class BankService {

    private TransactionHistory history = new TransactionHistory();

    public void deposit(User user, double amount) {
        if (amount > 0) {
            user.deposit(amount);
            history.addTransaction("Deposited $" + amount);
            System.out.printf("✅ %.2f deposited successfully.%n", amount);
        } else {
            System.out.println("⚠️ Invalid deposit amount!");
        }
    }

    public void withdraw(User user, double amount) {
        if (amount > 0 && amount <= user.getBalance()) {
            user.withdraw(amount);
            history.addTransaction("Withdrew $" + amount);
            System.out.printf("✅ %.2f withdrawn successfully.%n", amount);
        } else {
            System.out.println("⚠️ Invalid or insufficient balance for withdrawal!");
        }
    }

    public void showTransactionHistory() {
        history.displayTransactions();
    }
}
