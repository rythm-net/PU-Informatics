package decorator;

public class ColorDecorator extends CarDecorator {

    private String color;
    public ColorDecorator(Car decoratedCar, String color) {
        super(decoratedCar);
        this.color = color;
    }

    @Override
    public void create() {
        super.create();
        this.addColor();
    }

    private void addColor() {
        System.out.println("Adding color: " + this.color);
    }
}
