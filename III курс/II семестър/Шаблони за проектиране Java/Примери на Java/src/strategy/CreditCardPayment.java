package strategy;

public class CreditCardPayment implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    public CreditCardPayment(String name, String cardNumber, String expirationDate, String cvv) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Credit Card payment: " + amount);
    }

}
