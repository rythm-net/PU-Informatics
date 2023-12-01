package decorator;

public class DecoratorMain {
    public static void main(String[] args) {

        Car lada = new Lada();
        lada = new EngineDecorator(lada, "V8 Engine");
        lada = new ColorDecorator(lada, "Blue");
        lada.create();


        Car audi = new Audi();
        audi = new ColorDecorator(audi, "Green");
        audi.create();

    }
}
