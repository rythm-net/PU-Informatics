package decorator;

public class Audi implements Car {
    @Override
    public void create() {
        System.out.println("Creating a basic audi model");
    }
}
