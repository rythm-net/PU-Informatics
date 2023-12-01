package fmi.patterns.composite.step1;

public class Button extends Widget {
    @Override
    public void update() {
        System.out.printf("Draw Button: %d\n", widgetId);
    }
}
