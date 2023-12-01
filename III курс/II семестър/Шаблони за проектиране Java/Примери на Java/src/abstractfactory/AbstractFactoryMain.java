package abstractfactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        AbstractFactory shapeFactory =
                FactoryProducer.getFactory(ConstantsFactories.SHAPE_FACTORY);
        Shape shape = shapeFactory.getShape(ConstantsShapes.CIRCLE);
        shape.draw();

        AbstractFactory colorFactory =
                FactoryProducer.getFactory(ConstantsFactories.COLOR_FACTORY);
        Color color = colorFactory.getColor(ConstantsColors.BLUE);
        color.fill();

    }
}
