package decorator;

public abstract class CarDecorator implements Car {

    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        super();
        this.decoratedCar = decoratedCar;
    }

    @Override
    public void create() {
        this.decoratedCar.create();
    }
}
