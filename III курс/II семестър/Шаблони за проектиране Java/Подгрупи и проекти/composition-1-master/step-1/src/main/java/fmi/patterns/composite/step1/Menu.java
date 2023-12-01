package fmi.patterns.composite.step1;

public class Menu extends Widget {
    @Override
    public void update() {
        System.out.printf("Show Menu: %d\n", widgetId);
    }
}
