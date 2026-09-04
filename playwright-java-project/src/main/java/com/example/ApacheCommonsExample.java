package com.example;

import org.apache.commons.lang3.StringUtils;

public class ApacheCommonsExample {
    public static void main(String[] args) {
        String input = "Hello, World!";

        boolean isEmpty = StringUtils.isEmpty(input);
        System.out.println("Is the input string empty? " + isEmpty);

        String reversed = StringUtils.reverse(input);
        System.out.println("Reversed string: " + reversed);
    }
}
