package org.university.fmi.java.oop.model;

public class Professor extends Person {

    // Fields
    private String title;
    private int workExperience;
    private String faculty;
    private String department;

    // Constructor
    public Professor() {
        // Default constructor
    }

    public Professor(String name, int age, String title, int workExperience) {
        super(name, age);
        this.title = title;
        this.workExperience = workExperience;
    }

    // Methods
    @Override
    public void walk() {
        System.out.println("The professor is walking with 5 km.");
    }

    @Override
    public void run() {
        System.out.println("The professor is running with 2 km.");
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", egn='" + super.getEgn() + '\'' +
                ", gender=" + super.getGender() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                ", title='" + title + '\'' +
                ", workExperience=" + workExperience +
                ", faculty='" + faculty + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void getUpEarly() {

    }

    @Override
    public void getShower() {

    }

    @Override
    public void study() {

    }

    @Override
    public void think() {

    }

    @Override
    public void sleep() {

    }
}
