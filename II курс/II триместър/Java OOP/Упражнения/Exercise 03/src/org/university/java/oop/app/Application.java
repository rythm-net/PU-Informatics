package org.university.java.oop.app;

import org.university.fmi.java.oop.model.Person;
import org.university.fmi.java.oop.model.Professor;
import org.university.fmi.java.oop.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Student student = new Student("Ivan", 20);
        System.out.println("Student INFO: " + student);
        student.run();
        student.walk();

        Person professor = new Professor("Petar", 90, "Prof.", 60);
        System.out.println("Professor INFO: " + professor);
        professor.run();
        professor.walk();

        System.out.println("------------------------- ARRAY LIST DEMO ---------------------");
        // ArrayList<Person> people = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        people.add(student);
        people.add(professor);

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        people.remove(professor);

        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("------------------------- UNIVERSITY DATA ---------------------");
        readUniversityData();
    }

    public static void readUniversityData() {

        List<Person> people = new ArrayList<>();

        String answer="Y";
        while(answer.equalsIgnoreCase("Y")){
            System.out.println("Please select type of person");
            System.out.println("(1) Student");
            System.out.println("(2) Professor");

            int personType=0;

            do {
                if (personType == 0) {
                    personType = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("You need to choose 1 or 2.");
                    personType =0;
                }
            }while(personType!= 1 && personType !=2);


            Person person = switch (personType) {
                case 1 -> enterStudentData();
                case 2 -> enterProfessorData();
                default -> null;
            };

            people.add(person);

            System.out.println("Do you want to continue adding people: type Y or N.");
            answer = scanner.nextLine();
        }

        // print the data in the console
        for (Person p : people) {
            System.out.println(p);
        }
    }

    private static Student enterStudentData() {

        Student student = new Student();
        System.out.println("Enter student name");
        student.setName(scanner.nextLine());
        System.out.println("Enter student age");
        student.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter student university");
        student.setUniversity(scanner.nextLine());

        return student;
    }

    private static Professor enterProfessorData() {
        // TODO: Implement reading data from the console
        System.out.println("To be implemented!");

        // TODO: Change this when the object is ready to be returned
        return null;
    }
}