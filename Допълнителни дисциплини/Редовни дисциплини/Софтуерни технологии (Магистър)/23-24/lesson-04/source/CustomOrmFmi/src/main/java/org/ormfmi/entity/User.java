package org.ormfmi.entity;

public class User {

    public int id;

    public String name;


    @Override
    public String toString() {
        return "ID - " + this.id + " :: NAME - " + this.name;
    }
}
