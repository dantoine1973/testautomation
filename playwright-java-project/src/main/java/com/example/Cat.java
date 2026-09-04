package com.example;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " meows.");
    }

    public void climb() {
        System.out.println(getName() + " is climbing a tree.");
    }
}
