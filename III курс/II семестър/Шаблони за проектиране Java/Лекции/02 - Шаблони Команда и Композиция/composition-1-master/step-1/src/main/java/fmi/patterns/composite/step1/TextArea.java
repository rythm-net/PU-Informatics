package fmi.patterns.composite.step1;

public class TextArea extends Widget {
    @Override
    public void update() {
        System.out.printf("Print TextArea: %d\n", widgetId);
    }
}
