package fmi.patterns.composite.step1;

public abstract class Widget {
    protected static int sequence = 1;
    protected final int widgetId;

    public Widget() {
        widgetId = sequence++;
    }

    public abstract void update();
}
