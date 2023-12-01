package fmi.patterns.composite.step1;

public class Panel {
    private static int sequence = 1;
    private final int panelId;

    private final Widget[] widgets = {new Button(), new Button(), new Button(), new TextArea(), new TextArea()};

    public Panel() {
        panelId = sequence++;
    }

    /**
     * Специфичен метод за визуализиране на панел и останалите компоненти, които се съдържат в него
     */
    public void updateComponents() {
        System.out.printf("\nUpdate Panel: %d\n", panelId);
        System.out.println("-----------------------");

        if (widgets != null) {
            for (Widget widget : widgets) {
                widget.update();
            }
        }
    }
}
