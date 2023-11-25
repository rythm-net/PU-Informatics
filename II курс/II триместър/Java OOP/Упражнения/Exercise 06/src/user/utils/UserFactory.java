package user.utils;

import models.Professor;
import models.Student;
import models.User;

public final class UserFactory {

    public static User createUser(UserType userType, String firstName, String lastName) {
        if (UserType.STUDENT == userType) {
            return new Student(firstName, lastName);
        }
        if (UserType.USER == userType) {
            return new User(firstName, lastName);
        }
        if (UserType.PROFESSOR == userType) {
            return new Professor(firstName, lastName);
        }
        return null;
    }
}
