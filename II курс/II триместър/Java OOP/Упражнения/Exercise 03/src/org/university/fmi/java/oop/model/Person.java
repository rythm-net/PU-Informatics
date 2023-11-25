package org.university.fmi.java.oop.model;

public abstract class Person extends PureAbstractClass implements Comparable<Person> {

    // Fields
    private String name;
    private int age;
    private String egn;
    private char gender;
    private double weight;
    private double height;

    // Constructors
    public Person() {
        // default constructor
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String egn, char gender, double weight, double height) {
        this.name = name;
        this.age = age;
        this.egn = egn;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    // Methods
    @Override
    public int compareTo(Person person) {

        if (this.getAge() < person.getAge()) {
            return -1;
        } else if (this.getAge() > person.getAge()) {
            return 1;
        }

        // this.getAge() == person.getAge()
        return 0;
    }

    public abstract void walk();

    @Override
    public void getShower() {
        System.out.println("The person is getting a shower.");
    }

    @Override
    public void run() {
        System.out.println("The person is running with 5 km.");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", egn='" + egn + '\'' +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
