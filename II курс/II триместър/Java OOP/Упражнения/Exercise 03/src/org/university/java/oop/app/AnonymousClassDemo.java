package org.university.java.oop.app;

import org.university.fmi.java.oop.model.Person;
import org.university.fmi.java.oop.model.Professor;
import org.university.fmi.java.oop.model.Student;

import java.util.ArrayList;
import java.util.List;

public class AnonymousClassDemo {

    public static void main(String[] args) {
        testAnonymousClasses();

         testRTTI();
    }

    public static void testAnonymousClasses() {
        Student student = new Student("Konstantin", 30) {

            @Override
            public void run() {
                System.out.println("Anonymous student is running with 10 km");
            }
        };

        student.run();
    }

    public static void testRTTI() {
        List<Person> people = new ArrayList<>();

        Person student = new Student("Konstantin", 30);
        Person professor = new Professor("Ivan", 90, "Academic", 70);

        people.add(student);
        people.add(professor);


        for (Person person : people) {

            if (person instanceof Student) {
                Student castedPerson = (Student) person;

                System.out.printf("The student with name: %s is %d years old.",
                        castedPerson.getName(), castedPerson.getAge());
            }

            if (person instanceof Professor) {
                Professor castedPerson = (Professor) person;

                System.out.printf("The professor with name: %s is %d years old.",
                        castedPerson.getName(), castedPerson.getAge());
            }

            Class studentClass = Student.class;
            if (studentClass.isAssignableFrom(person.getClass())) {
                // TODO
            }

            if (studentClass.equals(person.getClass())) {
                // TODO
            }
        }
    }
}
