package visitor;

public class Book implements Product {

    private String isbnNumber;
    private String title;
    private double price;

    public Book(String isbnNumber, String title, double price) {
        this.isbnNumber = isbnNumber;
        this.title = title;
        this.price = price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double accept(ProductVisitor visitor) {
        return visitor.visit(this);
    }
}
