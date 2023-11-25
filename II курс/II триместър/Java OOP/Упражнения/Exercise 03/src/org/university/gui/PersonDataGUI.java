package org.university.gui;

import org.university.comparators.AgeComparator;
import org.university.comparators.NameComparator;
import org.university.comparators.PersonComparator;
import org.university.enums.DialogType;
import org.university.fmi.java.oop.model.Active;
import org.university.fmi.java.oop.model.Person;
import org.university.fmi.java.oop.model.Professor;
import org.university.fmi.java.oop.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonDataGUI {

    protected static Person[] people;
    JTable table;
    PersonDataModel personDataModel;

    public static void main(String[] args) {
        getPeople();

        PersonDataGUI gui = new PersonDataGUI();
        gui.createAndShowGUI();
    }

    public static void getPeople() {
        people = new Person[9];

        for (int i = 0; i < 8; i++) {
            Person student = Student.StudentGenerator.make();
            people[i] = student;
        }

        people[8] = new Professor("Professor", 90, "prof.", 50);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Списък с данни за хора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JLabel label = new JLabel("Списък с потребители", JLabel.CENTER);

        personDataModel = new PersonDataModel(people);
        table = new JTable(personDataModel);

        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);

        JButton buttonSortAge = new JButton("Сортирай по години");
        JButton buttonSort = new JButton("Сортирай");
        JButton buttonFilter = new JButton("Филтрирай");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(buttonSortAge);
        buttonsPanel.add(buttonSort);
        buttonsPanel.add(buttonFilter);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(label);
        container.add(scrollPane);

        // container.add(buttonSortAge, BorderLayout.BEFORE_FIRST_LINE);
        // container.add(buttonSort, BorderLayout.SOUTH);

        container.add(buttonsPanel, BorderLayout.SOUTH);

        buttonSortAge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(people);
                table.repaint();
            }
        });

        final JDialog sortDialog = new CustomDialog(getSortText(), this, DialogType.SORT);

        final  JDialog filterDialog = new CustomDialog(getFilterText(), this, DialogType.FILTER);

        buttonSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortDialog.pack();
                sortDialog.setVisible(true);
            }
        });

        buttonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterDialog.pack();
                filterDialog.setVisible(true);
            }
        });

        frame.setVisible(true);
    }

    public void sortTable(int intValue, JTable table, Person[] people) {
        PersonComparator comparator = null;

        switch (intValue) {
            case 1:
                comparator = new NameComparator();
                break;
            case 2:
                // TODO: Add comparator;
            case 3:
                comparator = new AgeComparator();
                break;
            case 4:
                // TODO;
            case 5:
                // TODO;
        }

        if (comparator == null) {
            Arrays.sort(people);
        } else {
            Arrays.sort(people, comparator);
        }

        table.repaint();
    }

    public void filterTable(int intValue, JTable table, Person[] people) {

        switch (intValue) {
            case 1:
                // Students
                this.personDataModel = new PersonDataModel(filterData(people, Student.class));
                break;
            case 2:
                // Professors
                this.personDataModel = new PersonDataModel(filterData(people, Professor.class));
                break;
            case 3:
                // People
                this.personDataModel = new PersonDataModel(filterData(people, Person.class));
                break;
        }

        table.setModel(this.personDataModel);
        table.repaint();
    }

    private Person[] filterData(Person[] people, Class<?> clazz) {
        List<Person> filteredData = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {

            if (clazz == Person.class) {
                if (!(people[i] instanceof Student) && !(people[i] instanceof Professor)) {
                    // not student or professor
                    filteredData.add(people[i]);
                }
            } else if (clazz.isInstance(people[i])) {
                // students OR professors
                filteredData.add(people[i]);
            }
        }

        Person[] filteredDataArray = new Person[filteredData.size()];
        filteredDataArray = filteredData.toArray(filteredDataArray);
        return filteredDataArray;
    }

    private static String getSortText() {
        return "Моля, въведете колона, по която искате да сортирате данните \n" +
                " 1 - Име \n" +
                " 2 - ЕГН \n" +
                " 3 - Години \n" +
                " 4 - Височина \n" +
                " 5 - Тегло \n";
    }

    private String getFilterText() {
        return "Моля, въведете цифрата на филтъра, по който искате да филтрирате данните \n" +
                " 1 - Студенти \n" +
                " 2 - Професори \n" +
                " 3 - Други \n";
    }
}
