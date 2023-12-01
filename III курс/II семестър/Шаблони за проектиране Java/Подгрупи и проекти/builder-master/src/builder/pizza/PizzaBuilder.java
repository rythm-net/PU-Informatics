package builder.pizza;

public interface PizzaBuilder {
    void reset();
    void buildDough();
    void buildSauce();
    void buildTopping();
    Pizza getPizza();
}
