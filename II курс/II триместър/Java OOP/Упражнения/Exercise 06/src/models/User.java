package models;

import user.utils.UserType;

public class User implements IUser{
    private final UserType userType;
    private String firstName;
    private String lastName;

   /* public User() {
        this(null, null);
    }*/

    public User(String firstName, String lastName) {
        //super();
        this(firstName, lastName, UserType.USER);
    }
    protected User(String firstName, String lastName, UserType userType) {
        //super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    @Override
    public String getFullName() {
        return userType.getTranslation()+" "+firstName+" "+lastName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
