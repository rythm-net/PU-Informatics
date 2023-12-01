package fmi.patterns.factory_method;

public class Airplane implements Vehicle {
    @Override
    public String getType() {
        return "Летящо превозно средство";
    }
}
