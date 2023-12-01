package fmi.patterns.composite.step2;

public abstract class Component {
    protected static int sequence = 1;
    protected final int componentId;

    public Component() {
        componentId = sequence++;
    }

    public abstract void update();
}
