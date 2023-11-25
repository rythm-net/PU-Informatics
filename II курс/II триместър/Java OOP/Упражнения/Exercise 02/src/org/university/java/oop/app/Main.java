package org.university.java.oop.app;

import org.university.java.oop.model.Person;
public class Main {
    public static void main(String[] args) {
        Person personOne = new Person();
        personOne.name = "Konstantin";
        personOne.setAge(30);
        System.out.println("Person one name: " + personOne.name);
        System.out.println("Person one age: " + personOne.getAge());
        personOne.walk();

        personOne.setLegsNumber(3);
        System.out.println("Legs: " + personOne.getLegsNumber());
        System.out.println("Arms: " + Person.ARMS_NUMBER);

        Person personTwo = new Person("Konstantin", 30);
        System.out.println("Person Two Legs: " + personTwo.getLegsNumber());
    }
}