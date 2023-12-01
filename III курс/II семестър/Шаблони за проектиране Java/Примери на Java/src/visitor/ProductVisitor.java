package visitor;

public interface ProductVisitor {
    double visit(Book book);
    double visit(Fruit fruit);
}
