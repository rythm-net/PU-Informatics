package strategy;

public class StrategyMain {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1 = new Product("Banana", 2.5);
        Product product2 = new Product("Juice", 1.7);

        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);

        //shoppingCart.pay(new PaypalPayment("test@abv.bg", "123"));
        shoppingCart.pay(new CreditCardPayment(
                "Ivan Ivanov",
                "1231 1231 1231 1231",
                "10/22",
                "111"));
    }

}
