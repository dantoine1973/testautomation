package com.example;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class GoogleGuavaExample {
    public static void main(String[] args) {

        // Join strings with a separator

        String input = Joiner.on(",  ").join("apple", "banana", "cherry");
        System.out.println("Joined string using Guava: " + input);

        // Create a list using Google Guava

        List<String> fruits = Lists.newArrayList("apple", "banana", "cherry");
        System.out.println("Fruit list: " + fruits);

    }
}
