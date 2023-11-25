package org.university.gui;

import org.university.fmi.java.oop.model.Person;

import javax.swing.table.AbstractTableModel;

public class PersonDataModel extends AbstractTableModel {

    private Person[] people;

    public PersonDataModel(Person[] people) {
        this.people = people;
    }

    @Override
    public int getRowCount() {
        return this.people.length;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return people[rowIndex].getName();
            case 1:
                return people[rowIndex].getEgn();
            case 2:
                return people[rowIndex].getAge();
            case 3:
                return people[rowIndex].getHeight();
            case 4:
                return people[rowIndex].getWeight();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Име";
            case 1:
                return "ЕГН";
            case 2:
                return "Години";
            case 3:
                return "Височина";
            case 4:
                return "Тегло";
        }

        return super.getColumnName(column);
    }
}
