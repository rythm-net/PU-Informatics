package models.car;

public class Car {
    private final String color;
    private final int power;
    private final int doors;

    private final String model;
    private final String type;

    private Car(String color, int power, int doors, String model, String type) {
        this.color = color;
        this.power = power;
        this.doors = doors;
        this.model = model;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", power=" + power +
                ", doors=" + doors +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    /*    public Car(String color, String model) {
        this(color,150,5,model,"sedan");
    }
    public Car(String color, String type) {
        this(color,150,5,"6",type);
    }*/

    public static class CarBuilder {
        private String color = "Red";
        private int power = 150;
        private int doors = 5;
        private String model = "6";
        private String type = "sedan";

        public CarBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder withPower(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder withDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public CarBuilder withModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public Car build() {
            return new Car(color, power, doors, model, type);
        }
    }
}
