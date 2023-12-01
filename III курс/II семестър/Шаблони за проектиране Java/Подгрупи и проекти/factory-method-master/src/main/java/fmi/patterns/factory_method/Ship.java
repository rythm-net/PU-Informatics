package fmi.patterns.factory_method;

public class Ship implements Vehicle {
    @Override
    public String getType() {
        return "Водно превозно средство";
    }
}
