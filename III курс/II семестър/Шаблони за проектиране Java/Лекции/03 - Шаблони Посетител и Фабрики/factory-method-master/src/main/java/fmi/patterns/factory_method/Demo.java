package fmi.patterns.factory_method;

/**
 * Класът демонстрира използването на шаблонът "Метод фабрика"
 */
public class Demo {
    private final static String VEHICLE_GROUND = "ground";
    private final static String VEHICLE_AIR = "air";
    private final static String VEHICLE_WATER = "water";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Очаква се параметър за средата на превозното средство");
            System.exit(-1);
        }

        VehicleFactory factory;

        switch (args[0]) {
            case VEHICLE_GROUND: factory = new CarFactory(); break;
            case VEHICLE_AIR:    factory = new AirplaneFactory(); break;
            case VEHICLE_WATER:  factory = new ShipFactory(); break;
            default: throw new IllegalArgumentException("Невалидна среда");
        }

        createAndPrintVehicleType(factory);
    }

    private static void createAndPrintVehicleType(VehicleFactory factory) {
        Vehicle vehicle = factory.createVehicle();

        System.out.println(vehicle.getType());
    }
}
