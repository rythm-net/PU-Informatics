package builder.pizza;

public class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void printPizza() {
        System.out.print("\tDough: " + this.getDough() + "\n" +
                "\tSauce: " + this.getSauce() + "\n" +
                "\tTopping: " + this.getTopping());
    }
}
