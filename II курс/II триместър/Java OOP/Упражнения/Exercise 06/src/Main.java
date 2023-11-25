import cars.models.Car;
import menu.models.AMeetBall;
import menu.models.FriedMeatBalls;
import menu.models.GrilledMeatBalls;
import models.*;
import teaching.models.Subject;
import user.utils.UserFactory;
import user.utils.UserType;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*IFullName user= new User("Ivan", "Ivanov");
        IUser student = new Student("Ivan", "Ivanov");
        Professor professor = new Professor("Ivan", "Ivanov");*/
        /*IFullName user = UserFactory.createUser(UserType.USER, "Ivan", "Ivanov");
        IUser student = UserFactory.createUser(UserType.STUDENT, "Ivan", "Ivanov");
        User professor = UserFactory.createUser(UserType.PROFESSOR, "Ivan", "Ivanov");
        professor.setFirstName("Peter");
        System.out.println(user.getFullName());
        System.out.println(student);
        System.out.println(professor);

        addGradesExample();*/

        //createMeatBalls();
        buildCar();


    }

    private static IUser createAnonymousUser() {
        return new IUser() {
            @Override
            public String getFirstName() {
                return "John";
            }

            @Override
            public String getFullName() {
                return "Anonymous: " + getFirstName() + " " + getLastName();
            }

            @Override
            public String getLastName() {
                return "Doe";
            }
        };
    }

    private static void addGradesExample() {
        Subject oop = new Subject();
        Student s1 = (Student) UserFactory.createUser(UserType.STUDENT, "Ivan", "Ivanov");
        Student s2 = (Student) UserFactory.createUser(UserType.STUDENT, "Petar", "Petrov");
        oop.addStudent(s1);
        oop.addStudent(s2);
        oop.addGrade(s1, 3);
        oop.addGrade(s1, 5);
        oop.addGrade(s1, 6);
        System.out.println(oop.getFinalGrade(s1));
    }

    private static void createMeatBalls() {
        List<AMeetBall> order = new ArrayList<>();
        order.add(new FriedMeatBalls(60, 40));
        order.add(new GrilledMeatBalls(0, 100, 100));
        order.add(new GrilledMeatBalls(60, 40, 60));
        GrilledMeatBalls nullMeatBall = null;
        order.add(nullMeatBall);
        System.out.println("Вашата поръчка включва:");
        for (AMeetBall meetBall : order) {
            if (meetBall != null) {
                meetBall.printPreparationInfo();
            }
            if (meetBall instanceof GrilledMeatBalls) {
                ((GrilledMeatBalls) meetBall).printType();
            }
        }
    }

    private static void buildCar() {
        final Car.CarBuilder carBuilder = new Car.CarBuilder();

        Car car = carBuilder.withColor("red")
                .withDoors(3)
                .withTypeEngine("diesel")
                .withType("sport")
                .withPower(150)
                .build();
        Car car2 = new Car.CarBuilder().withColor("red")
                .withTypeEngine("diesel")
                .withType("sport")
                .build();
        System.out.println(car + "\n");
        System.out.println(car2);
    }
}