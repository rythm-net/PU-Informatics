package decorator;

public class EngineDecorator extends CarDecorator {

    private String engine;
    public EngineDecorator(Car decoratedCar, String engine) {
        super(decoratedCar);
        this.engine = engine;
    }

    @Override
    public void create() {
        super.create();
        this.addEngine();
    }

    private void addEngine() {
        System.out.println("Adding engine: " + this.engine);
    }

}
