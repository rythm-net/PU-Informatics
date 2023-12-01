package composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private String name;
    private double salary;
    List<Employee> employees;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.employees = new ArrayList<>();
    }

    @Override
    public void add(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        this.employees.remove(employee);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void printEmployeeInfo() {
        System.out.println(
                "Manager: " + this.getName()
                        + " with salary: " + this.getSalary());

        for (Employee employee : this.employees) {
            employee.printEmployeeInfo();
        }

    }
}
