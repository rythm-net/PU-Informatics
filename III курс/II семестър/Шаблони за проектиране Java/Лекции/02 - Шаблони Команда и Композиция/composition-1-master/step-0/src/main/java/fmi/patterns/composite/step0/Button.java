package fmi.patterns.composite.step0;

/**
 * Клас, за хипотетичен визуален компонент - бутон.
 */
public class Button {
    private static int sequence = 1;
    private final int buttonId;

    public Button() {
        buttonId = sequence++;
    }

    /**
     * Специфичен метод за визуализиране на бутон
     */
    public void draw() {
        System.out.printf("Draw Button: %d\n", buttonId);
    }
}
