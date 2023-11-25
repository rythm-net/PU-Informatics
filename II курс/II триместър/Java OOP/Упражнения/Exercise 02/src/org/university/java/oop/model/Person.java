package org.university.java.oop.model;
public class Person {

    // constants
    // static properties
    public static final int ARMS_NUMBER = 2;
    public static int legsNumber = 2;

    // non-static properties
    // fields == properties == attributes
    public String name;
    String egn;
    char gender;
    int age;
    double weight;
    double height;

    // methods, behaviour
    public void walk() {
        System.out.println("The person with name: " + this.getName() + " is walking");
    }

    // constructors
    public Person() {
        // default constructor
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String egn, char gender,
                  int age, double weight, double height) {
        this.name = name;
        this.egn = egn;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // getters and setters
    public int getLegsNumber() {
        return legsNumber;
    }

    public void setLegsNumber(int legs) {
        legsNumber = legs;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
