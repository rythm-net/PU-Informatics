package abstractfactory;

public abstract class AbstractFactory {
    abstract Color getColor(String colorName);
    abstract Shape getShape(String shapeName);
}
