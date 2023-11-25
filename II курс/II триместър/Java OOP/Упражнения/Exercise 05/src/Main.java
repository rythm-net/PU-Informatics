import interfaces.IUser;
import menu.model.AMeatBall;
import menu.model.FriedMeatBall;
import menu.model.GrilledMeatBall;
import models.Student;
import models.User;
import models.car.Car;
import models.car.Car.CarBuilder;
import teachers.util.UserFactory;
import teachers.util.UserType;
import teaching.models.GradeBook;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        /*IUser user = new User("Ivan", "Ivanov");
        IUser student = new Student("Peter", "Petrov");*/

       /* IUser user = UserFactory.createUser(UserType.USER,"Ivan", "Ivanov");
        User student = UserFactory.createUser(UserType.STUDENT,"Tralalal", "Petrov");
        Student  student2 = (Student) UserFactory.createUser(UserType.STUDENT,"Ivan", "Petrov");
        student.setLastName("test");
        GradeBook gradeBook = new GradeBook();
        gradeBook.addGrade(student2, 6);
        gradeBook.addGrade(student2, 5);
        gradeBook.addGrade(student2, 5);
        gradeBook.addGrade(student2, 2);
        System.out.println(gradeBook.getFinalGrade(student2));


        //user.setFirstName("Ivan");
       // user.setLastName("Ivanov");
        System.out.println(user.getFullName());
        System.out.println(student.getFullName());//->Student Peter Petrov;
        System.out.println(student);//->Student Peter Petrov;
        System.out.println(user);//->Ivan Ivanov;
*/
        //orderMenu();

        createCars();
    }

    private static void orderMenu() {
        GrilledMeatBall grilledMeatBall = new GrilledMeatBall(60, 40, 60);
        List<AMeatBall> order = new ArrayList<>();
        order.add(grilledMeatBall);
        order.add(new FriedMeatBall(100,0,100));
        order.add(new FriedMeatBall(40,60,100));
        System.out.println("Вашата поръчка включва:");
        for (AMeatBall meatBall:order){
            meatBall.printPreparationInfo();
            if(meatBall instanceof FriedMeatBall){
                int temp = ((FriedMeatBall) meatBall).getTemp();
                System.out.println(temp);
            }
        }
    }


    private static void createCars(){
        CarBuilder carBuilder = new Car.CarBuilder();
        Car car1 = carBuilder
                .withPower(190)
                .withModel("3")
                .build();
        Car car2 = new Car.CarBuilder()
                .withPower(230)
                .withDoors(5)
                .build();
        System.out.println(car1);
        System.out.println(car2);
    }

}