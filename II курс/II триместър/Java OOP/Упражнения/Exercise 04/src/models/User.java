package models;

import interfaces.IUser;

public class User implements IUser {
    private String firstName;
    private String lastName;
    public User(){
        this(null, null);
    }

  /*  public User(String firstName) {

    }
    public User(String lastName) {

    }*/
    public User(String firstName, String lastName) {
        //super();
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public String getFullName() {
        return firstName+" "+lastName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.getFullName();
    }
}
