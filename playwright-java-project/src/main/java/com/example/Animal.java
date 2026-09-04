package com.example;

public class Animal {
 private String name;

    // Constructor to initialize the object
    public Animal(String name) {
        this.name = name;
    }

    // Getter method to access the private field
    public String getName() {
        return name;
    }

    public void makeSound() {
        System.out.println(name + " makes some generic animal sound.");
    }

}
