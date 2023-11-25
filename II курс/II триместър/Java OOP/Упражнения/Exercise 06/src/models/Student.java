package models;

import user.utils.UserType;

public class Student extends User{
    public Student(String firstName, String lastName) {
                super(firstName, lastName, UserType.STUDENT);
    }

/*    @Override
    public String getFullName() {
        return "Student " +super.getFullName();
    }*/
}
