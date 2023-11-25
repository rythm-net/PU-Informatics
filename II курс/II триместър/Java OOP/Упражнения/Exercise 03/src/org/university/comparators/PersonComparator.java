package org.university.comparators;

import org.university.fmi.java.oop.model.Person;

import javax.swing.*;
import java.util.Comparator;

public abstract class PersonComparator implements Comparator<Person> {

    protected int sortOrder = 1;

    public void setSortOrder(SortOrder sortOrder) {

        if (sortOrder.equals(SortOrder.DESCENDING)) {
            this.sortOrder = -1;
        } else {
            this.sortOrder = 1;
        }
    }
}
