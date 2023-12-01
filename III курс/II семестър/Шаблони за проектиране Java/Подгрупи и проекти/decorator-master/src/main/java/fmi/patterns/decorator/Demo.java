package fmi.patterns.decorator;

public class Demo {
    public static void main(String[] args) {
        ChristmasTree tree1 = new NaturalChristmasTree();

        TopDecorator topDecorator = new TopDecorator(tree1);

        LedLightsDecorator ledLightsDecorator = new LedLightsDecorator(topDecorator);

        ToyDecorator toyDecorator = new ToyDecorator(ledLightsDecorator, "звезда");

        toyDecorator = new ToyDecorator(toyDecorator, "звезда");

        toyDecorator = new ToyDecorator(toyDecorator, "сфера");

        buildChristmasTree(toyDecorator);

        ChristmasTree tree2 = new ArtificialChristmasTree();

        ToyDecorator toyDecorator2 = new ToyDecorator(tree2, "Дядо коледа");
        toyDecorator2 = new ToyDecorator(toyDecorator2, "Висулка");

        TopDecorator topDecorator2 = new TopDecorator(toyDecorator2);

        buildChristmasTree(topDecorator2);
    }

    /**
     * Методът представя клиентската част на кода
     * @param tree компонентът, с който работим
     */
    private static void buildChristmasTree(ChristmasTree tree) {
        System.out.println(tree.build());
    }
}
