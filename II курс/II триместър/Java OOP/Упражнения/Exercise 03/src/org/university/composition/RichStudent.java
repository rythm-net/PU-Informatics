package org.university.composition;

import org.university.fmi.java.oop.model.Student;

public class RichStudent {

    private Student student;

    public RichStudent(String name, int age) {
        this.student = new Student(name, age);
    }

    @Override
    public String toString() {
        return this.student.toString();
    }

    public void run() {
        student.run();
    }

    // Getters and Setters
    public String getName() {
        return this.student.getName();
    }

    public void setName(String name) {
        this.student.setName(name);
    }

    public int getAge() {
        return this.student.getAge();
    }

    public void setAge(int age) {
        this.student.setAge(age);
    }
}
