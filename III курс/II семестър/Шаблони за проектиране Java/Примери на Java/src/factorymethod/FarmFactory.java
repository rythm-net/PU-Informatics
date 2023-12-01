package factorymethod;

public abstract class FarmFactory {

    public abstract FarmProduct createProduct(String productName);

    public FarmProduct produceProduct(String productName) {
        FarmProduct product = createProduct(productName);
        product.prepare();
        return product;
    }
}
