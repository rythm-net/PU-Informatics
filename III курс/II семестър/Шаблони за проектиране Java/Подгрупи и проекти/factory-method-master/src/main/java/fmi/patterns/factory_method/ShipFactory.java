package fmi.patterns.factory_method;

public class ShipFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Ship();
    }
}
