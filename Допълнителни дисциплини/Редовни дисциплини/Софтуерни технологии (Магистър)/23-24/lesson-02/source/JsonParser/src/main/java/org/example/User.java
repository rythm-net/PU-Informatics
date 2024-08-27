package org.example;

public class User {

    @JSONField( name = "first_name")
    public String fname;
    @JSONField( name = "last_name")
    public String lname;

    @JSONField()
    public int age;

    @JSONField()
    public int personalNumber;
}

// { "fname": "Mihail", "lname": "Petrov", "age": 31}