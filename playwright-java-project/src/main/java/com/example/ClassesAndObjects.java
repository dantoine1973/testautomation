package com.example;

public class ClassesAndObjects {

    /**
     * Multiline command example:
     * Classes & Objects: Think of a class like a breed of aminal, defining general
     * traits.
     * An object is like a specific animal of that breed, with its own unique
     * characteristics.
     * Please view the Animal, Dog, and Cat class files.
     */
    public static void main(String[] args) {
        Animal myAnimal = new Animal("Generic Animal");
        myAnimal.makeSound();
        Dog myDog = new Dog("Buddy");
        myDog.makeSound();
        myDog.fetch();
        Cat myCat = new Cat("Whiskers");
        myCat.makeSound();
        myCat.climb(); // Calling the climb method specific to Cat
    }
}
