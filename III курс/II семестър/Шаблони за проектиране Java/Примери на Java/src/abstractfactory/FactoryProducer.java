package abstractfactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryName) {

        if(factoryName.equals(ConstantsFactories.COLOR_FACTORY)) {
            return new ColorFactory();
        }
        if(factoryName.equals(ConstantsFactories.SHAPE_FACTORY)) {
            return new ShapeFactory();
        }
        System.out.println("Unknown factory: " + factoryName);
        return null;
    }
}
