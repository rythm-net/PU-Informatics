package models;

import interfaces.ILatsName;
import interfaces.IUser;

public class Student extends User implements IUser, ILatsName {

    public Student (String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public String getFullName() {
        return "Student " + super.getFullName();
    }


/* public void setLastName(String lastName) {
        super.setLastName(null);
    }*/
}
