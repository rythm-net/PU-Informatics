import interfaces.IUser;
import menu.model.AMeatBall;
import menu.model.FriedMeatBall;
import menu.model.GrilledMeatBall;
import models.Student;
import models.User;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        IUser user = new User("Ivan", "Ivanov");
        IUser student = new Student("Peter", "Petrov");
        new User();
        //user.setFirstName("Ivan");
       // user.setLastName("Ivanov");
        System.out.println(user.getFullName());
        System.out.println(student.getFullName());//->Student Peter Petrov;
        System.out.println(student);//->Student Peter Petrov;
        System.out.println(user);//->Ivan Ivanov;

        GrilledMeatBall grilledMeatBall = new GrilledMeatBall(60, 40, 60);
        List<AMeatBall> order = new ArrayList<>();
        order.add(grilledMeatBall);
        order.add(new FriedMeatBall(100,0,100));
        order.add(new FriedMeatBall(40,60,100));
        System.out.println("Вашата поръчка включва:");
        for (AMeatBall meatBall:order){
            meatBall.printPreparationInfo();
        }
    }
}