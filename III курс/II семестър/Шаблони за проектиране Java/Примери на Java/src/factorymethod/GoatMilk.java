package factorymethod;

public class GoatMilk extends FarmProduct {
    @Override
    public void prepare() {
        System.out.println("Preparing goat milk");
    }
}
