package com.example;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " barks.");
    }

    public void fetch() {
        System.out.println(getName() + " is fetching the ball.");
    }

}
