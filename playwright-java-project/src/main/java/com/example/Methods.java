package com.example;


public class Methods {

    // Example 1
    public static void greet() {
        System.out.println("Hello, I am the greet() method!");
    }

    // Example 2
    public static int add(int a, int b) {
        return a + b;
    }

    // Example 3 - non-static method which requires an instance of the class to be called
    public void instanceGreet(String message) {
        System.out.println("Message: " + message);
    }
    public static void main(String[] args) {

        int a = 5, b = 10;

        greet(); // Example 1

        int sum = add(a, b); // Example 2
        System.out.println("The sum of " + a + " and " + b + " is: " + sum);

        Methods myMethods = new Methods(); // Create an instance of the class
        myMethods.instanceGreet("Hello, I am the instanceGreet() method!"); // Example 3
    }
}
