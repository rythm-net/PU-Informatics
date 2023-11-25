package cars.models;

public class Car {
    private final String color;
    private final int doors;
    private final String typeEngine;
    private final int power;
    private final String type;

    private Car(String color, int doors, String typeEngine, int power, String type) {
        this.color = color;
        this.doors = doors;
        this.typeEngine = typeEngine;
        this.power = power;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public static class CarBuilder {
        private String color = "black";
        private int doors = 5;
        private String typeEngine = "petrol";
        private int power = 120;
        private String type = "Sedan";

        public CarBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder withDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public CarBuilder withTypeEngine(String typeEngine) {
            this.typeEngine = typeEngine;
            return this;
        }

        public CarBuilder withPower(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public Car build() {
            return new Car(color, doors, typeEngine, power, type);
        }
    }

    @Override
    public String toString() {
        String result = "Color: " + color + "\nDoors: " + doors + "\nType of engine: " + typeEngine + "\nPower: " + power + "\nType: " + type;
        return result;
    }
}
