package org.university.fmi.java.oop.model;

import java.util.concurrent.ThreadLocalRandom;

public class Student extends Person {

    // Fields
    private String university;
    private String speciality;
    private String facultyNumber;

    // Constructors
    public Student() {
        // Default constructors
        // super();
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, String university, String speciality, String facultyNumber) {
        super(name, age);
        // super.setName(name);
        // super.setAge(age);

        this.university = university;
        this.speciality = speciality;
        this.facultyNumber = facultyNumber;
    }

    public Student(String name, int age, String egn, char gender, double weight, double height, String university, String speciality, String facultyNumber) {
        super(name, age, egn, gender, weight, height);
        this.university = university;
        this.speciality = speciality;
        this.facultyNumber = facultyNumber;
    }

    @Override
    public void getUpEarly() {
        // TODO
    }

    @Override
    public void walk() {
        System.out.println("The student is walking with 10 km.");
    }

    @Override
    public void run() {
        System.out.println("The student is running with 10 km.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", egn='" + super.getEgn() + '\'' +
                ", gender=" + super.getGender() +
                ", weight=" + super.getWeight() +
                ", height=" + super.getHeight() +
                ", university='" + university + '\'' +
                ", speciality='" + speciality + '\'' +
                ", facultyNumber='" + facultyNumber + '\'' +
                '}';
    }

    // Getters and Setters
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
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

    public static class StudentGenerator {
        static String[] names = {"Yana", "Elitsa", "Plamen", "Konstantin", "Petar"};
        static String[] universities = {"PU", "SU", "NBU", "TU", "MU", "VUSI"};
        static String[] specialities = {"Informatics", "Mathematics", "Pharmacy", "Engineering", "Biology", "Chemistry"};

        public static Student make() {
            int arrayIndex = ThreadLocalRandom.current().nextInt(0, names.length);
            String name = names[arrayIndex];

            arrayIndex = ThreadLocalRandom.current().nextInt(0, universities.length);
            String university = universities[arrayIndex];

            arrayIndex = ThreadLocalRandom.current().nextInt(0, specialities.length);
            String speciality = specialities[arrayIndex];

            int age = ThreadLocalRandom.current().nextInt(18, 60);

            String facultyNumber = String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));

            return new Student(name, age, university, speciality, facultyNumber);
        }
    }
}
