package visitor;

public interface Product {
    double accept(ProductVisitor visitor);
}
