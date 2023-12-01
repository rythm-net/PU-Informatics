package fmi.patterns.factory_method;

public class Car implements Vehicle {
    @Override
    public String getType() {
        return "Наземно превозно средство";
    }
}
