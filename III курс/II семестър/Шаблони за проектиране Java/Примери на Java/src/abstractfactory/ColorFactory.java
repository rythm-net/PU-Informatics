package abstractfactory;

public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String colorName) {
        if(colorName.equals(ConstantsColors.GREEN)) {
            return new Green();
        }
        if(colorName.equals(ConstantsColors.BLUE)) {
            return new Blue();
        }
        System.out.println("Unknown color: " + colorName);
        return null;
    }

    @Override
    Shape getShape(String shapeName) {
        System.out.println("Color factory cannot create: " + shapeName);
        return null;
    }
}
