package decorator;

public class Lada implements Car {
    @Override
    public void create() {
        System.out.println("Creating a basic lada model");
    }
}
