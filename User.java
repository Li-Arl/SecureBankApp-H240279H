package com.ZimBank.model;

public class User {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private double balance;

    public User(String username, String password, String fullName, String email, String phone, double balance) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public double getBalance() { return balance; }

    // Setters
    public void setBalance(double balance) { this.balance = balance; }

    // ✅ Add these methods:
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
