package com.example;

public class ConditionsAndLoops {
    public static void main(String[] args) {
        int number = -1;

        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        int day = 5;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }


        // Looping constructs
        // for loop example

        for (int i = 1; i <= 5; i++) {
            System.out.println("For loop iteration: " + i);
        }

        // while loop example

        int count = 1;

        while (count <= 5) {
            System.out.println("While loop iteration: " + count);
            count++;
        }
    }
}