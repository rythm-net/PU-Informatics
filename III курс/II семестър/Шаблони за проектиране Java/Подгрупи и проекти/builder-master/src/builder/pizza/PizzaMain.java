package builder.pizza;

public class PizzaMain {
    public static void main(String[] args) {
        PizzaBuilder pepperoniPizzaBuilder = new PepperoniPizzaBuilder();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();

        /* Pepperoni */
        Chef chef = new Chef(pepperoniPizzaBuilder);
        chef.constructPizza();
        Pizza pepperoni = pepperoniPizzaBuilder.getPizza();
        System.out.println("\nPepperoni built result:");
        pepperoni.printPizza();

        System.out.println();

        /* Hawaiian */
        chef.setPizzaBuilder(hawaiianPizzaBuilder);
        chef.constructPizza();
        Pizza hawaiian = hawaiianPizzaBuilder.getPizza();
        System.out.println("\nHawaiian built result: " + hawaiian.hashCode());
        hawaiian.printPizza();

        System.out.println();

        /* The builder does not store a reference to the already generated Pizza object after calling the getPizza() method.
           A new Pizza object is automatically created. It can be built with the same builder via the constructPizza() method. */
        chef.constructPizza();
        Pizza h = hawaiianPizzaBuilder.getPizza();
        System.out.println("\nHawaiian built result: " + h.hashCode());
        h.printPizza();
    }
}
