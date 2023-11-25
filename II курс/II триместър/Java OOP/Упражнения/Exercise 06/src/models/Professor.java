package models;

import user.utils.UserType;

public class Professor extends User{
    public Professor(String firstName, String lastName) {
        super(firstName, lastName, UserType.PROFESSOR);
    }
/*
    @Override
    public String getFullName() {
        return "Professor "+ super.getFullName();
    }*/

    @Override
    public void setLastName(String lastName) {
        super.setLastName("'"+lastName+"'");
    }
}
