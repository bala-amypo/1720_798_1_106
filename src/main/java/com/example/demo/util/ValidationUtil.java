package com.example.demo.util;

public class ValidationUtil {
    
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
    
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}