package models;

import interfaces.ILatsName;
import interfaces.IUser;
import teachers.util.UserType;

public class Student extends User implements IUser, ILatsName {

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String getFullName() {
        return UserType.STUDENT.getTranslation() + " " + super.getFullName();
    }


/* public void setLastName(String lastName) {
        super.setLastName(null);
    }*/
}
