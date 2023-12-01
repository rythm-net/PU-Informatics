package visitor;

public class PriceCalculator implements ProductVisitor {

    @Override
    public double visit(Book book) {
        double price = book.getPrice();
        if(price > 50) {
            price = price - 5;
        }

        System.out.println("Book price: " + price);
        return price;
    }

    @Override
    public double visit(Fruit fruit) {
        double price = fruit.getWeight() * fruit.getPricePerKg();
        System.out.println("Fruit price: " + price);
        return price;
    }
}
