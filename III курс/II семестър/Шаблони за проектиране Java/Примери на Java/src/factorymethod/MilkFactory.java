package factorymethod;

public class MilkFactory extends FarmFactory {

    @Override
    public FarmProduct createProduct(String productName) {

        if(productName.equals(ConstantsFarmProducts.COW_MILK)) {
            return new CowMilk();
        }
        if(productName.equals(ConstantsFarmProducts.GOAT_MILK)) {
            return new GoatMilk();
        }
        System.out.println("Unknown milk product: " + productName);
        return null;
    }
}
