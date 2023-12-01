package abstractfactory;

public class ShapeFactory extends AbstractFactory {
    @Override
    Color getColor(String colorName) {
        System.out.println("Shape factory cannot create: " + colorName);
        return null;
    }

    @Override
    Shape getShape(String shapeName) {
        if(shapeName.equals(ConstantsShapes.CIRCLE)) {
            return new Circle();
        }
        if(shapeName.equals(ConstantsShapes.RECTANGLE)) {
            return new Rectangle();
        }
        System.out.println("Unknown color: " + shapeName);
        return null;
    }
}
