package fmi.patterns.factory_method;

public class AirplaneFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Airplane();
    }
}
