package strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
    }

    public double getItemsPrice() {
        return this.productList.stream()
                .mapToDouble(Product::getPrice)
                .reduce(0, (acc, price) -> acc + price);
    }

    public void pay(PaymentStrategy paymentStrategy) {
        double amount = this.getItemsPrice();
        paymentStrategy.pay(amount);
    }

}
