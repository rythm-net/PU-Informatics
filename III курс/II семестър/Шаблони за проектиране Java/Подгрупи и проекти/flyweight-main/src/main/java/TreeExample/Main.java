package TreeExample;

public class Main {
    private static String[] shapes = {"Spruce", "Beech", "Pine", "Oak", "Maple"};

    public static void main(String[] args) {
        for (int i= 0; i<5; i++){
            System.out.println();
            String shape = getRandomShape();
            String color = getRandomColor();
            Tree tree = TreeFactory.getTree(shape);
            tree.render(color);
        }
    }
    static String getRandomShape(){
        return shapes[(int)(Math.random() * shapes.length)];
    }
    private static String getRandomColor() {
        String[] colors = {"Red", "Green", "Blue"};
        return colors[(int) (Math.random() * colors.length)];
    }
}
