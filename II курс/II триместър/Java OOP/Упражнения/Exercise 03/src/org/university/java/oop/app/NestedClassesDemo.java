package org.university.java.oop.app;

import org.university.enums.AnimalName;
import org.university.fmi.java.oop.model.Student;
import org.university.nestedclasses.MysteryAnimal;

import java.util.ArrayList;
import java.util.List;

public class NestedClassesDemo {
    public static void main(String[] args) {
        // testNestedClasses();
        testStaticNestedClasses();
    }

    private static void testNestedClasses() {
        MysteryAnimal mysteryAnimal1 = new MysteryAnimal(AnimalName.Bella);
        mysteryAnimal1.showSound();

        MysteryAnimal mysteryAnimal2 = new MysteryAnimal(AnimalName.Chloe);
        mysteryAnimal2.showSound();

        MysteryAnimal mysteryAnimal3 = new MysteryAnimal(AnimalName.Betty);
        mysteryAnimal3.showSound();
    }

    private static void testStaticNestedClasses() {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Student student = Student.StudentGenerator.make();
            students.add(student);
        }

        for (Student s : students) {
            System.out.println(s.toString());
        }
    }
}
