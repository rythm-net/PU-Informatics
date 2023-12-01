package TreeExample;

// Concrete Flyweight
class TreeImplement implements Tree{
    private final String shape;

    TreeImplement(String shape) {
        this.shape = shape;
    }

    public void render(String color){
        System.out.println("Rendering a " + color + " " + shape + " tree.");
    }
}