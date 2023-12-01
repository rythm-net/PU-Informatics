package visitor;

public class VisitorMain {

    public static void main(String[] args) {
        Product apple = new Fruit("Apple", 2.5, 2);
        Product book = new Book("12312ASA12", "The Witcher", 60);

        PriceCalculator calc = new PriceCalculator();
        double applePrice = apple.accept(calc);
        double bookPrice = book.accept(calc);
        //TODO use calculated values
        System.out.println(applePrice + bookPrice);
    }

}
