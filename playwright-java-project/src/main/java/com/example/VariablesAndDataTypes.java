package com.example;


import java.util.ArrayList;

public class VariablesAndDataTypes {
    public static void main(String[] args) {
        // Declare and initialize variables of different data types
        int myInt = 10;
        double myDouble = 20.5;
        float myFloat = 15.5f;
        char myChar = 'A';
        boolean myBoolean = true;
        String myString = "Hello, World!";

// int array and ArrayList

        int[] myIntArray = { 1, 2, 3, 4, 5 };

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Print the values of the variables
        System.out.println("Integer: " + myInt);
        System.out.println("Double: " + myDouble);
        System.out.println("Float: " + myFloat);
        System.out.println("Character: " + myChar);
        System.out.println("Boolean: " + myBoolean);
        System.out.println("String: " + myString);
        System.out.println("Integer Array: " + java.util.Arrays.toString(myIntArray));
        System.out.println("ArrayList: " + fruits);
    }
}
