package builder.pizza;

public class HawaiianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    @Override
    public void reset() {
        this.pizza = new Pizza();
    }

    public HawaiianPizzaBuilder() {
        this.reset();
    }

    @Override
    public void buildDough() {
        this.pizza.setDough("Yeast dough");
    }

    @Override
    public void buildSauce() {
        this.pizza.setSauce("Tomato sauce");
    }

    @Override
    public void buildTopping() {
        this.pizza.setTopping("Pineapple, Cheese, Ham");
    }

    /* Set the builder instance to be ready to start producing another product.
       In this case call the reset() method to dispose the previously generated product. */
    @Override
    public Pizza getPizza() {
        Pizza createdPizza = this.pizza;
        this.reset();
        return createdPizza;
    }
}
