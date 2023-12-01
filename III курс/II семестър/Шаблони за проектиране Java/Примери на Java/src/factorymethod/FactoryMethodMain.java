package factorymethod;

public class FactoryMethodMain {
    public static void main(String[] args) {
        FarmFactory milkFactory = new MilkFactory();
        FarmProduct farmProduct = milkFactory.produceProduct(ConstantsFarmProducts.COW_MILK);
    }
}
