package fmi.patterns.composite.step0;

/**
 * Клас, за хипотетичен визуален компонент - текстова област.
 */
public class TextArea {
    private static int sequence = 1;
    private final int textAreaId;

    public TextArea() {
        textAreaId = sequence++;
    }

    /**
     * Специфичен метод за визуализиране на текстова област
     */
    public void print() {
        System.out.printf("Print TextArea: %d\n", textAreaId);
    }
}
