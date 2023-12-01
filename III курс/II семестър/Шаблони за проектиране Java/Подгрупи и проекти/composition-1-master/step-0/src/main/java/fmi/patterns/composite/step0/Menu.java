package fmi.patterns.composite.step0;

/**
 * Клас, за хипотетичен визуален компонент - меню.
 */
public class Menu {
    private static int sequence = 1;
    private final int menuId;

    public Menu() {
        menuId = sequence++;
    }

    /**
     * Специфичен метод за визуализиране на меню
     */
    public void show() {
        System.out.printf("Show Menu: %d\n", menuId);
    }
}
