package com.ZimBank.service;

import java.util.HashMap;
import java.util.Map;
import com.ZimBank.model.User;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public UserService() {
        // Default user with all required fields
        users.put("Chiedza", new User(
                "Chiedza",                      // username
                "1234",                         // password
                "CHIEDZA Mugaviri",             // full name
                "mugavirichiedza@gmail.com",    // email
                "+263772889456",                // phone number
                2000.00                         // balance
        ));
    }

    // Register a new user
    public boolean registerUser(String username, String password, String fullName, String email, String phone, double balance) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }

        users.put(username, new User(username, password, fullName, email, phone, balance));
        return true;
    }

    // Find a user by username
    public User getUser(String username) {
        return users.get(username);
    }
}
