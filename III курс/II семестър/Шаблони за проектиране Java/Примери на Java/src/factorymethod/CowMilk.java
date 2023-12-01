package factorymethod;

public class CowMilk extends FarmProduct {
    @Override
    public void prepare() {
        System.out.println("Preparing cow milk");
    }
}
