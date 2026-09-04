package com.example;

public class SimpleErrorHandling {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        String invalidNumber = "abc";
        try {
            int number = Integer.parseInt(invalidNumber);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
