package fmi.patterns.composite.step1;

public class Window {
    private final Widget[] widgets = {
            new Button(), new Button(),
            new Menu(),
            new TextArea(), new TextArea(), new TextArea()
    };

    private final Panel[] panels = {new Panel()};

    /**
     * Специфичен метод за визуализиране на прозорец и останалите компоненти, които се съдържат в него
     */
    public void display() {
        System.out.println("Display Window");
        System.out.println("-----------------------");

        if (widgets != null) {
            for (Widget widget : widgets) {
                widget.update();
            }
        }

        if (panels != null) {
            for (Panel panel: panels) {
                panel.updateComponents();
            }
        }
    }

}
