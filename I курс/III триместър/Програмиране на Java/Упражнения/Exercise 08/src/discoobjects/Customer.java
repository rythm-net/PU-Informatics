package discoobjects;

public class Customer {

    private String firstName;
    private String lastName;
    private SexEnum sex;

    private int age;

    public Customer(String firstName, String lastName, SexEnum sex) {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.sex        = sex;
    }

    public boolean isMale() {
        return this.sex == SexEnum.MALE;
    }

    public boolean isFemale() {
        return this.sex == SexEnum.FEMALE;
    }
}